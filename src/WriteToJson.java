public class WriteToJson {
    public static String write() {
        StringBuilder stringBuilder = new StringBuilder("{");
            stringBuilder.append("{");
            stringBuilder.append("\"id\":").append(",");
            stringBuilder.append("\"firstName\":\"").append("\",");
            stringBuilder.append("\"secondName\":\"").append("\",");
            stringBuilder.append("\"birthDate\":\"").append("\",");
            stringBuilder.append("\"hireDate\":\"").append("\",");
            stringBuilder.append("\"jobTitle\":\"").append("\",");
            stringBuilder.append("\"salary\":").append(",");
            stringBuilder.append("]");
            stringBuilder.append("},");
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
