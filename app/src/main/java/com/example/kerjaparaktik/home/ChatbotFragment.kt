package com.example.kerjaparaktik.home
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import com.example.kerjaparaktik.R

class ChatbotFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chatbot, container, false)

        val webView: WebView = view.findViewById(R.id.webView)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // URL chatbot Watson Assistant
        val chatbotUrl = "https://web-chat.global.assistant.watson.appdomain.cloud/preview.html?backgroundImageURL=https%3A%2F%2Fus-south.assistant.watson.cloud.ibm.com%2Fpublic%2Fimages%2Fupx-9be5a095-c16c-4d73-94d5-e9e98a7090c6%3A%3A7ad391ce-4f49-4bf7-8963-432ba7135369&integrationID=ca559c37-423b-413a-a692-2ea495c9cb52&region=us-south&serviceInstanceID=9be5a095-c16c-4d73-94d5-e9e98a7090c6"

        // Load URL chatbot
        webView.loadUrl(chatbotUrl)
        return view
    }
}
