package DATE_BASE;

import MODELS.User;
import com.google.gson.*;

import java.lang.reflect.Type;

public class UserAdapter implements JsonSerializer<User>, JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type type,
                            JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonPrimitive prim = (JsonPrimitive) jsonObject.get("CLASSNAME");
        String className = prim.getAsString();

        Class<?> klass = null;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new JsonParseException(e.getMessage());
        }
        return context.deserialize(jsonObject.get("INSTANCE"), klass);
    }

    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext context) {
        JsonObject retValue = new JsonObject();
        String className = user.getClass().getName();
        retValue.addProperty("CLASSNAME", className);
        JsonElement elem = context.serialize(user);
        retValue.add("INSTANCE", elem);
        return retValue;
    }
}
