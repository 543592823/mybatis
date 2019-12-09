//package com.zyc.p2p.base.util;
//
//import org.springframework.stereotype.Component;
//
//@Component
//public class JSONResult {
//    private boolean success = true;
//    private String msg;
//
//    public JSONResult() {
//        super();
//    }
//
//    public JSONResult(String msg){
//        super();
//        this.msg = msg;
//    }
//    public JSONResult(Boolean success, String msg){
//        super();
//        this.success = success;
//        this.msg = msg;
//    }
//
//    public boolean isSuccess() {
//        return success;
//    }
//
//    public void setSuccess(boolean success) {
//        this.success = success;
//    }
//
//    public String getMsg() {
//        return msg;
//    }
//
//    public void setMsg(String msg) {
//        this.msg = msg;
//    }
//}
package com.zyc.p2p.base.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JSONResult {
    private boolean success = true;
    private String message;
    public void mark(String errorMsg){
        this.success = false;
        this.message = errorMsg;
    }

    public JSONResult() {}

    public JSONResult(String message) {
        this.message = message;
    }
}

