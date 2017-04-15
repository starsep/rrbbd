package com.starsep.rrbbd.bidding;

import j2html.tags.DomContent;

/**
 * Interface of element which is used to generate html.
 */
public interface IHtml {
    /**
     * Bidding in html format.
     * @return bidding as DomContent
     */
    DomContent biddingHtml();

    /**
     * ForumBridge bidding in html format.
     * @return forum bidding as DomContent
     */
    DomContent forumHtml();
}
