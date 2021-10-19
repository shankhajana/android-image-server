package com.shankhajana.imageCapture;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryResponse {

@SerializedName("body")
@Expose
private List<GalleryResponseBody> body = null;
@SerializedName("requestId")
@Expose
private String requestId;

public List<GalleryResponseBody> getBody() {
return body;
}

public void setBody(List<GalleryResponseBody> body) {
this.body = body;
}

public String getRequestId() {
return requestId;
}

public void setRequestId(String requestId) {
this.requestId = requestId;
}

}