package io.social.socialcommunity.domain.user.domain

import io.social.socialcommunity.domain.support.jpa.BaseEntity
import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class User(
	@Column(length = 50, nullable = false)
	var userId: String,

	@Column(length = 50, nullable = false)
	var password: String,

	@Column(length = 50, nullable = false)
	var town: String,

	var createdAt: OffsetDateTime = OffsetDateTime.now()
) : BaseEntity()