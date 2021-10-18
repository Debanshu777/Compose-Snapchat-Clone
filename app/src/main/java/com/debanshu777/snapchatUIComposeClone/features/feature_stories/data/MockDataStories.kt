package com.debanshu777.snapchatUIComposeClone.features.feature_stories.data

import com.debanshu777.snapchatUIComposeClone.common.domain.model.SnapDurationType
import com.debanshu777.snapchatUIComposeClone.common.domain.model.User
import com.debanshu777.snapchatUIComposeClone.features.feature_chat.domain.ContentType
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.domain.model.FriendsStory
import com.debanshu777.snapchatUIComposeClone.features.feature_stories.domain.model.Story
import com.google.android.exoplayer2.C
import java.util.*

fun MockDataStories():List<FriendsStory>{
    return listOf(
        FriendsStory(
            userName= "John Doe",
            stories = listOf(
                Story(
                    userId = 1234,
                    timeStamp = Date().time,
                    contentType = ContentType.image,
                    mediaURL = "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG",
                    snapDurationType = SnapDurationType.oneTime
                )
            ),
            storyCount = 1,
            thumbnail = "https://upload.wikimedia.org/wikipedia/commons/0/0f/Eiffel_Tower_Vertical.JPG"
        ),
        FriendsStory(
            userName= "Jean Doe",
            stories = listOf(
                Story(
                    userId = 1235,
                    timeStamp = Date().time,
                    contentType = ContentType.image,
                    mediaURL = "https://images.unsplash.com/photo-1526512340740-9217d0159da9?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dmVydGljYWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80",
                    snapDurationType = SnapDurationType.oneTime
                )
            ),
            storyCount = 1,
            thumbnail = "https://images.unsplash.com/photo-1526512340740-9217d0159da9?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8dmVydGljYWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80"
        ),
        FriendsStory(
            userName= "Alice Doe",
            stories = listOf(
                Story(
                    userId = 1236,
                    timeStamp = Date().time,
                    contentType = ContentType.image,
                    mediaURL = "https://images.unsplash.com/photo-1531966662811-c6501e46eda6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8dmVydGljYWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80",
                    snapDurationType = SnapDurationType.oneTime
                )
            ),
            storyCount = 1,
            thumbnail = "https://images.unsplash.com/photo-1531966662811-c6501e46eda6?ixid=MnwxMjA3fDB8MHxzZWFyY2h8N3x8dmVydGljYWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80"
        ),
        FriendsStory(
            userName= "Allen Doe",
            stories = listOf(
                Story(
                    userId = 1237,
                    timeStamp = Date().time,
                    contentType = ContentType.image,
                    mediaURL = "https://i.pinimg.com/736x/33/08/8a/33088a684f8af83e6b6be61828190a7b.jpg",
                    snapDurationType = SnapDurationType.oneTime
                )
            ),
            storyCount = 1,
            thumbnail = "https://i.pinimg.com/736x/33/08/8a/33088a684f8af83e6b6be61828190a7b.jpg"
        ),
        FriendsStory(
            userName= "Ellen Doe",
            stories = listOf(
                Story(
                    userId = 1237,
                    timeStamp = Date().time,
                    contentType = ContentType.image,
                    mediaURL = "https://images.unsplash.com/photo-1544376798-89aa6b82c6cd?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8dmVydGljYWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80",
                    snapDurationType = SnapDurationType.oneTime
                )
            ),
            storyCount = 1,
            thumbnail = "https://images.unsplash.com/photo-1544376798-89aa6b82c6cd?ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8dmVydGljYWx8ZW58MHx8MHx8&ixlib=rb-1.2.1&w=1000&q=80"
        ),
        FriendsStory(
            userName= "Mark Doe",
            stories = listOf(
                Story(
                    userId = 1237,
                    timeStamp = Date().time,
                    contentType = ContentType.image,
                    mediaURL = "https://webneel.com/daily/sites/default/files/images/daily/06-2013/22-best-vertical-panoramic-photography.jpg",
                    snapDurationType = SnapDurationType.oneTime
                )
            ),
            storyCount = 1,
            thumbnail = "https://webneel.com/daily/sites/default/files/images/daily/06-2013/22-best-vertical-panoramic-photography.jpg"
        ),
    )
}