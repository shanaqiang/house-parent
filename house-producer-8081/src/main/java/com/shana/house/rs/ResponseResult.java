package com.shana.house.rs;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述:<br>
 * 〈〉
 *
 * @author xiana
 * @create 2019/11/19
 * @since 1.0.0
 */
public class ResponseResult {
    private String code;
    private String message;
    private Map<String,Object> maps=new HashMap<>();

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult() {
    }

    public ResponseResult add(String key, Object value) {
        this.getMaps().put(key, value);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }
}

