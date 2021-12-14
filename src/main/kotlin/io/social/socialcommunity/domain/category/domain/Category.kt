package io.social.socialcommunity.domain.category.domain

import io.social.socialcommunity.domain.support.jpa.BaseAggregateRoot
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

	@ManyToOne
	var user: User,

	var isInterest: Boolean = true,

	var createdAt: OffsetDateTime = OffsetDateTime.now()
) : BaseAggregateRoot<Category>() {
	fun interest() {
		this.isInterest = true
	}

	fun uninterest() {
		Assert.isTrue(this.type != CategoryType.BASIC, "잘못된 접근입니다.")
		this.isInterest = false
	}
}