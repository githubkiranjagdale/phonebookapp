package com.bikkadit.PhoneBookAppliction.Entity;



import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "CONTACT_DTLS")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CONTACT_ID")
	private Integer contactId;
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name="CONTACT_NUMBER")
	private Long contactNumber;
	@Column(name="CONTACT_EMAIL")
	private String contactEmail;
	@Column(name="ACTIVE_SWITCH")
	private Character activeSwitch;
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	@Column(name="UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
}
