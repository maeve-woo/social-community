package io.social.socialcommunity.domain.commentlike.domain

import io.social.socialcommunity.domain.comment.domain.Comment
import io.social.socialcommunity.domain.support.jpa.BaseEntity
import io.social.socialcommunity.domain.user.domain.User
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class CommentLike(
	@ManyToOne(fetch = FetchType.LAZY)
	var comment: Comment,

	@ManyToOne(fetch = FetchType.LAZY)
	var user: User
) : BaseEntity()