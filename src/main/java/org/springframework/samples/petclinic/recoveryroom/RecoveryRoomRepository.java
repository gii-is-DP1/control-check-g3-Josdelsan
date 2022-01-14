package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer> {
    List<RecoveryRoom> findAll();

    @Query("SELECT rt FROM RecoveryRoomType rt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();

    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);

    @Query("SELECT rt FROM RecoveryRoomType rt WHERE name=?1")
    RecoveryRoomType getRecoveryRoomType(String name);

    @Query("SELECT r FROM RecoveryRoom r WHERE size>?1")
    List<RecoveryRoom> findBySizeMoreThan(double size);
}
