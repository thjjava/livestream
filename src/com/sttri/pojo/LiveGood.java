package com.sttri.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 * ÷±≤•µ„‘ﬁ
 * @author thj
 *
 */
@Entity
@Table(name = "live_good")
public class LiveGood implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private String id;
	//private String devId;
	private TblDev dev;
	private String clientIP;
	private String goodTime;
	
	public LiveGood() {
	}
	
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 50)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	@ManyToOne
	@JoinColumn(name="devId")
	@NotFound(action=NotFoundAction.IGNORE)
	public TblDev getDev() {
		return dev;
	}

	public void setDev(TblDev dev) {
		this.dev = dev;
	}


	@Column(name = "ClientIP")
	public String getClientIP() {
		return this.clientIP;
	}

	public void setClientIP(String clientIP) {
		this.clientIP = clientIP;
	}

	@Column(name = "GoodTime", length = 30)
	public String getGoodTime() {
		return this.goodTime;
	}

	public void setGoodTime(String GoodTime) {
		this.goodTime = GoodTime;
	}


}