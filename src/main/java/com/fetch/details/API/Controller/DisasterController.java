package com.fetch.details.API.Controller;



import com.fetch.details.API.Config.DisasterRequest;
import com.fetch.details.API.Config.DisasterResponse;
import com.fetch.details.API.Config.DisasterWrapperService;
import com.fetch.details.API.Models.ImageLink;
import com.fetch.details.API.Models.Incident;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.InputStream;
import org.springframework.http.HttpHeaders; // KEEP THIS
import java.util.List;
import java.io.InputStream;
import java.net.URL;

@RestController
@RequestMapping("/disaster")
public class DisasterController {

    @Autowired
    private DisasterWrapperService disasterWrapperService;

    @PostMapping("/save")
    public DisasterResponse saveIncidentAndImageLink(@RequestBody DisasterRequest request) {
        return disasterWrapperService.saveIncidentAndImageLink(request);
    }

    // ✅ Get all incidents
    @GetMapping("/incidents")
    public List<Incident> getAllIncidents() {
        return disasterWrapperService.getAllIncidents();
    }

    // ✅ Get all image links
    @GetMapping("/images/view/{id}")
    public ResponseEntity<byte[]> viewImageById(@PathVariable Long id) {
        try {
            ImageLink imageLink = disasterWrapperService.getImageLinkById(id);

            URL url = new URL(imageLink.getImageUrl());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            try (InputStream is = url.openStream()) {
                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, bytesRead);
                }
            }

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Adjust if needed

            return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }
}

