package fr.logkey.logkeypro

data class PushNotification(
    val data: NotificationData,
    val to: String
)