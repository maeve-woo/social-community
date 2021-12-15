package io.social.socialcommunity.domain.post.domain

import io.social.socialcommunity.domain.category.domain.Category
import io.social.socialcommunity.domain.support.jpa.BaseEntity
import io.social.socialcommunity.domain.user.domain.User
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
class Post(
	@ManyToOne(fetch = FetchType.LAZY)
	var category: Category,

	@ManyToOne(fetch = FetchType.LAZY)
	var writer: User,

	@Column(nullable = false)
	@Lob
	var content: String,

	var createdAt: OffsetDateTime = OffsetDateTime.now()

) : BaseEntity() {

}