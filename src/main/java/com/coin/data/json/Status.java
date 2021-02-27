package com.coin.data.json;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coin.util.DateUtils;
import com.google.gson.annotations.SerializedName;

@Entity
@Table(name="status")
public class Status {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@SerializedName(value="timestamp")
	private Date timestamp;

	@SerializedName(value="error_code")
	private int errorCode;

	@SerializedName(value="error_message")
	private String errorMessage;

	@SerializedName(value="elapsed")
	private int elapsed;

	@SerializedName(value="credit_count")
	private int creditCount;

	@SerializedName(value="notice")
	private String notice;

	@SerializedName(value="total_count")
	private int totalCount;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = DateUtils.parseJsonDateFormatToDate(timestamp);
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getElapsed() {
		return elapsed;
	}
	public void setElapsed(int elapsed) {
		this.elapsed = elapsed;
	}
	public int getCreditCount() {
		return creditCount;
	}
	public void setCreditCount(int creditCount) {
		this.creditCount = creditCount;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
