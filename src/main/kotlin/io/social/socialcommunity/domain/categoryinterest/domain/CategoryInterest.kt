package io.social.socialcommunity.domain.categoryinterest.domain

import io.social.socialcommunity.domain.category.domain.Category
import io.social.socialcommunity.domain.category.domain.CategoryType
import io.social.socialcommunity.domain.support.jpa.BaseEntity
import io.social.socialcommunity.domain.user.domain.User
import org.springframework.util.Assert
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class CategoryInterest(
	@ManyToOne(fetch = FetchType.LAZY)
	var category: Category,

	@ManyToOne(fetch = FetchType.LAZY)
	var user: User
) : BaseEntity() {
	companion object {
		fun create(category: Category, user: User): CategoryInterest {
			Assert.isTrue(category.type != CategoryType.BASIC)

			return CategoryInterest(category, user)
		}
	}
}