package io.social.socialcommunity.domain.postempathy.domain

import io.social.socialcommunity.domain.post.domain.Post
import io.social.socialcommunity.domain.support.jpa.BaseEntity
import io.social.socialcommunity.domain.user.domain.User
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class PostEmpathy(
	@ManyToOne(fetch = FetchType.LAZY)
	var post: Post,

	@ManyToOne(fetch = FetchType.LAZY)
	var user: User
) : BaseEntity()