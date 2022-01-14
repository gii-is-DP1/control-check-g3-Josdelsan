package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.samples.petclinic.model.NamedEntity;
import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoom extends NamedEntity{

    @NotNull
    @Min(0)
    double size;

    @NotNull
    boolean secure;

    @OneToMany(mappedBy = "recoveryRoom")
    private List<Visit> visits;

    @ManyToOne(optional = false)
    @JoinColumn(name = "recoveryroomtype_id")
    private RecoveryRoomType roomType;
}
