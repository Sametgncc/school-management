package com.project.contactmessage.mapper;

import com.project.contactmessage.dto.ContactMessageRequest;
import com.project.contactmessage.dto.ContactMessageResponse;
import com.project.contactmessage.entity.ContactMessage;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ContactMessageMapper {

    // pojo --------> dt

    public ContactMessageResponse contactMessageToResponse(ContactMessage contactMessage) {
        return ContactMessageResponse.builder()
                .name(contactMessage.getName())
                .subject(contactMessage.getSubject())
                .message(contactMessage.getMessage())
                .email(contactMessage.getEmail())
                .localDateTime(LocalDateTime.now())
                .build();

    }

    // pojo ------------->dto


    public ContactMessage requestToContactMessage(ContactMessageRequest contactMessageRequest) {
        return ContactMessage.builder()
                .name(contactMessageRequest.getName())
                .message(contactMessageRequest.getMessage())
                .subject(contactMessageRequest.getSubject())
                .email(contactMessageRequest.getEmail())
                .dateTime(LocalDateTime.now())
                .build();

    }
}
