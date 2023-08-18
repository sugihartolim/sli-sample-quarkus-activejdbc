package com.insys.anjforms.json;

import lombok.Data;

@Data
public class JsonRevision {
    private Long revisionId;
    private Long templateId;
    private Integer revisionNumber;
    private String revisionTimestamp;
    private String uuid;
    private String description;     
    private Long userId; 
    private Long approvedBy; 
    private Long reviewedBy; 
    private String jsonSchema; 
    private String b64Jrxml;
    private String b64Jasper;
}
