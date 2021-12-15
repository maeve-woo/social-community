package io.social.socialcommunity.domain.categoryempathy.domain

import io.social.socialcommunity.domain.category.domain.Category
import io.social.socialcommunity.domain.support.jpa.BaseEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToOne

@Entity
class CategoryEmpathy(
	@OneToOne
	var category: Category,

	@Column(length = 200, nullable = false)
	var name: String
) : BaseEntity()