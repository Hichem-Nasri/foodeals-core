package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.UuidGenerator;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "assignments")
@Setter
@Getter
public class WorkSchedule extends AbstractEntity<UUID>{

	@Id
	@GeneratedValue
	@UuidGenerator
	private UUID id;

	@Enumerated(EnumType.STRING)
	private DayOfWeek dayOfWeek;

	private LocalTime morningStart;
	private LocalTime morningEnd;
	private LocalTime afternoonStart;
	private LocalTime afternoonEnd;
	
	@ManyToOne(cascade = CascadeType.ALL)
    private User collaborator;

}
