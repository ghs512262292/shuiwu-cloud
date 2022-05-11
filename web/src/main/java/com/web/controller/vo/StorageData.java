package com.web.controller.vo;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

@Data
public class StorageData {
    List<Map<String, Object>> data;
    String text;
}
