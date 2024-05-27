package com.project.contactmessage.mapper;

import com.project.contactmessage.dto.ContactMessageRequest;
import com.project.contactmessage.dto.ContactMessageResponse;
import com.project.contactmessage.entity.ContactMessage;

import java.time.LocalDateTime;

public class ContactMessageMapper {

    // pojo --------> dto
    public ContactMessageResponse contactMessagetoRespones(ContactMessage contactMessage ){
        return ContactMessageResponse.builder()
                .name(contactMessage.getName())
                .subject(contactMessage.getSubject())
                .message(contactMessage.getMessage())
                .email(contactMessage.getEmail())
                .localDateTime(LocalDateTime.now())
                .build();

    }

    // pojo ------------->dto

    public ContactMessage requesToContactMessage(ContactMessageRequest contactMessageRequest){
        return ContactMessage.builder()
                .name(contactMessageRequest.getName())
                .message(contactMessageRequest.getMessage())
                .subject(contactMessageRequest.getSubject())
                .email(contactMessageRequest.getEmail())
                .dateTime(LocalDateTime.now())
                .build();

    }


    public ContactMessageResponse contactMessageToResponse(ContactMessage savedData) {

    }

    public ContactMessage requestToContactMessage(ContactMessageRequest contactMessageRequest) {

    }
}
