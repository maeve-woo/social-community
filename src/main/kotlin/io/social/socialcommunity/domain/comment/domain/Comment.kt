package io.social.socialcommunity.domain.comment.domain

import io.social.socialcommunity.domain.post.domain.Post
import io.social.socialcommunity.domain.support.jpa.BaseEntity
import io.social.socialcommunity.domain.user.domain.User
import java.time.OffsetDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class Comment(
	@Column(length = 2000, nullable = false)
	var content: String,

	@ManyToOne(fetch = FetchType.LAZY)
	var writer: User,

	@ManyToOne(fetch = FetchType.LAZY)
	var post: Post,

	var createdAt: OffsetDateTime = OffsetDateTime.now(),

	@ManyToOne(fetch = FetchType.LAZY)
	var parent: Comment? = null
) : BaseEntity()