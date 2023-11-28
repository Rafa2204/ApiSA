package com.example.colaboraCityApi.entities;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.example.colaboraCityApi.dto.CitizenInputDto;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="cidadao")
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
public class Citizen extends User {


     public Citizen(CitizenInputDto dto){
        super.setName(dto.getName());
        this.phone = dto.getPhone();
        super.setAdress(dto.getAdress());
        super.setSenha(dto.getSenha());
        super.setAdmin(dto.getAdmin());
        super.setEmail(dto.getEmail());

    }

    public Citizen(String name) {
        super.getName() ;  
        
    }
    


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;


    @Embedded
    private FileInfo foto;

    @OneToMany(mappedBy = "cidadao")
    private List<Publication> publicacao;


    
}
