package com.shankhajana.imageCapture;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryResponseBody {

@SerializedName("imageId")
@Expose
private String imageId;
@SerializedName("userid")
@Expose
private String userid;
@SerializedName("title")
@Expose
private String title;
@SerializedName("description")
@Expose
private String description;
@SerializedName("originalFileName")
@Expose
private String originalFileName;
@SerializedName("uploadedFileName")
@Expose
private String uploadedFileName;
@SerializedName("uploadFilePath")
@Expose
private String uploadFilePath;

public String getImageId() {
return imageId;
}

public void setImageId(String imageId) {
this.imageId = imageId;
}

public String getUserid() {
return userid;
}

public void setUserid(String userid) {
this.userid = userid;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getDescription() {
return description;
}

public void setDescription(String description) {
this.description = description;
}

public String getOriginalFileName() {
return originalFileName;
}

public void setOriginalFileName(String originalFileName) {
this.originalFileName = originalFileName;
}

public String getUploadedFileName() {
return uploadedFileName;
}

public void setUploadedFileName(String uploadedFileName) {
this.uploadedFileName = uploadedFileName;
}

public String getUploadFilePath() {
return uploadFilePath;
}

public void setUploadFilePath(String uploadFilePath) {
this.uploadFilePath = uploadFilePath;
}

}