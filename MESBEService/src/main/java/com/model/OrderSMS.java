package com.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "order_sms")
public class OrderSMS {
	
    @GenericGenerator(
            name = "orderSMSequenceGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "orderSMSequence"),
                    @Parameter(name = "initial_value", value = "1000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )

    @Id
    @GeneratedValue(generator = "orderSMSequenceGenerator")
    @JsonProperty("id")
    private long id;
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDestAddress() {
		return destAddress;
	}
	public void setDestAddress(String destAddress) {
		this.destAddress = destAddress;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getScheduledDate() {
		return scheduledDate;
	}
	public void setScheduledDate(LocalDateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
    @Column(name="body", columnDefinition="varchar(280) DEFAULT NULL")
	private String body;
    
    @Column(name="dest_address", columnDefinition="varchar(64) DEFAULT NULL")
    private String destAddress;
    @Column(name="creation_date", columnDefinition="TIMESTAMP DEFAULT NULL")
    private LocalDateTime creationDate;
    @Column(name="scheduled_date", columnDefinition="TIMESTAMP DEFAULT NULL")
    private LocalDateTime scheduledDate;


}
