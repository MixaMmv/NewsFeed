package com.example.newsfeedapp.feature.main_screen.data.api.model

import com.google.gson.annotations.SerializedName

class NewsArticlesModel(
        @SerializedName("source")
        val source: NewsSourceModel,
        @SerializedName("author")
        val author: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("urlToImage")
        val urlToImage: String?,
        @SerializedName("content")
        val content: String?

)


/*
-"articles": [
-{
    -"source": {
        "id": null,
        "name": "Fox Business"
    },
    "author": "Reuters",
    "title": "Evergrande CEO in Hong Kong for restructuring, asset sale talks, sources say - Fox Business",
    "description": "Evergrande Group's chief executive is holding talks in Hong Kong with investment banks and creditors over a possible restructuring and asset sales, two people said, as the Chinese developer battles against default on more than $300 billion in debts.",
    "url": "https://www.foxbusiness.com/markets/evergrande-ceo-hong-kong-restructuring-asset-sale-talks",
    "urlToImage": "https://a57.foxnews.com/static.foxbusiness.com/foxbusiness.com/content/uploads/2021/09/0/0/china-centre-Evergrande.jpg?ve=1&tl=1",
    "publishedAt": "2021-10-16T01:44:07Z",
    "content": "HONG KONG - Evergrande Group's chief executive is holding talks in Hong Kong with investment banks and creditors over a possible restructuring and asset sales, two people said, as the Chinese develop… [+4234 chars]"
}
]*/
