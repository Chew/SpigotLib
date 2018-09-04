package gyurix.chat;

import net.md_5.bungee.api.chat.HoverEvent;

public class ChatHoverEvent {
    public ChatHoverEventType action;
    public ChatTag value;

    public ChatHoverEvent(ChatHoverEventType action, String value) {
        this.action = action;
        this.value = action == ChatHoverEventType.show_text ? ChatTag.fromColoredText(value) : new ChatTag(value);
    }

    public HoverEvent toSpigotHoverEvent() {
        return new HoverEvent(action.toSpigotHoverAction(), value.toBaseComponents());
    }
}

