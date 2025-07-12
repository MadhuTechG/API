package com.fetch.details.API.Controller;

import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Repo.ImageLinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageLinkController {

    @Autowired
    private ImageLinkRepo imageLinkRepo;

    // POST: Save image link
    @PostMapping("/save")
    public String saveImageLink(@RequestBody ImageLink imageLink) {
        imageLinkRepo.save(imageLink);
        return "Image link saved successfully.";
    }

    // GET: View all image links
    @GetMapping("/all")
    public List<ImageLink> getAllImageLinks() {
        return imageLinkRepo.findAll();
    }

    // GET: View image by ID
    @GetMapping("/view/{id}")
    public ResponseEntity<byte[]> viewImage(@PathVariable Long id) throws IOException {
        ImageLink imageLink = imageLinkRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found for id " + id));

        String imageUrl = imageLink.getImageUrl();

        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();

        int responseCode = connection.getResponseCode();
        if (responseCode != HttpURLConnection.HTTP_OK) {
            throw new RuntimeException("Image not found at URL: " + imageUrl + ", response code: " + responseCode);
        }

        try (InputStream in = connection.getInputStream()) {
            byte[] imageBytes = in.readAllBytes();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // adjust if needed based on actual image type

            return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
        }
    }
}
