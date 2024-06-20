package com.info.company.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="Imagedata")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageData {
	  
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   	
	    @Lob
	    @Column(name = "logo",length = 1000)
	    private byte[] logo;
	    
	    @Lob
	    @Column(name = "signature",length = 1000)
	    private byte[] signature;
	    
	    private Boolean isLogo;
	  
	    @OneToOne
	    private Company companyId;

		
		
	    
}
