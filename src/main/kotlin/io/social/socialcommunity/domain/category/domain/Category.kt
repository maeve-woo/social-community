package io.social.socialcommunity.domain.category.domain

import io.social.socialcommunity.domain.support.jpa.BaseEntity
import io.social.socialcommunity.domain.user.domain.User
import org.springframework.util.Assert
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
class Category(
	@Enumerated(EnumType.STRING)
	@Column(length = 50, nullable = false)
	var type: CategoryType,

	@Column(length = 100, nullable = false)
	var name: String,

	var createdAt: OffsetDateTime = OffsetDateTime.now(),
) : BaseEntity()