/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.insys.anjforms.json;

import lombok.Data;

/**
 *
 * @author sugih
 * Type	Description	Required Keys	Optional Keys
 * success  All went well, and (usually) some data was returned.	status, data	
 * fail     There was a problem with the data submitted, or some pre-condition of the API call wasn't satisfied	status, data	
 * error    An error occurred in processing the request, i.e. an exception was thrown	status, message	code, data 
 */
@Data
public class JSendWrapper {
    private static final String SUCCESS = "success"; 
    private static final String FAIL = "fail"; 
    private static final String ERROR = "error"; 
    //
    private String status;
    private String message;
    private Integer code;
    private Object data;
    private Object nav; 

    public JSendWrapper(String s, Object o, String m) {
        this.status = s;
        this.data = o;
        this.message = m;    
    }
    
    public static JSendWrapper success(Object o) {
        JSendWrapper w = new JSendWrapper(JSendWrapper.SUCCESS, o, "OK");
        return w; 
    }
    
    public static JSendWrapper success(Object o, String m) {
        JSendWrapper w = new JSendWrapper(JSendWrapper.SUCCESS, o, m);
        return w; 
    }

    public static JSendWrapper error(Object o, String m) {
        JSendWrapper w = new JSendWrapper(JSendWrapper.ERROR, o, m);
        return w;         
    }
    
    public static JSendWrapper fail(Object o, String m) {
        JSendWrapper w = new JSendWrapper(JSendWrapper.FAIL, o, m);
        return w;         
    }
    
}
   