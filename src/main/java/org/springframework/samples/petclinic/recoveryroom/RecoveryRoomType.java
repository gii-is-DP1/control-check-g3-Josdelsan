package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoomType extends BaseEntity{

    @Size(min = 3, max = 50)
	@Column(unique = true)
	private String name;

    @OneToMany(mappedBy = "roomType")
    private List<RecoveryRoom> recoveryRooms;
}
