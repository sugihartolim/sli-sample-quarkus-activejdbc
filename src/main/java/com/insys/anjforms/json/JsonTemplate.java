package com.insys.anjforms.json;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class JsonTemplate {
    private Long templateId;
    private String templateCode;
    private String templateName;
    private String description;
    private String templateGroupingCode;
    private String uuid;
    List<JsonRevision> revisions = new ArrayList<>();
}
