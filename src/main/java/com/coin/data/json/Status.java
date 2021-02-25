package com.coin.data.json;

import java.time.LocalDateTime;

import com.coin.util.DateUtils;

public class Status {
	private LocalDateTime timeStamp;
	private int errorCode;
	private String errorMessage;
	private int elapsed;
	private int creditCount;
	private String notice;
	private int totalCount;

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = DateUtils.parseJsonDateFormat(timeStamp);
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
