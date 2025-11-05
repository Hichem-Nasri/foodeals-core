package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "notifications-settings")

@Getter
@Setter
public class NotificationSettings extends AbstractEntity<UUID> {


	    @Id
	    @GeneratedValue
	    @UuidGenerator
	    private UUID id;

	    @ManyToOne
	    @JoinColumn(name = "user_id", nullable = false)
	    private User user;

	    private boolean calendarReminders;
	    private boolean pushNotifications;
	    private boolean importantUpdates;
	    private boolean promotions;
	    private boolean notificationBoxSurprise;

	    @ElementCollection(fetch = FetchType.EAGER)
	    @CollectionTable(name = "notification_reminder_days", joinColumns = @JoinColumn(name = "notification_settings_id"))
	    @Column(name = "day")
	    private List<String> remindMe;
}
