public record UserRecord(String login, Long id, String url) {

    @Override
    public String toString() {
        return "Nome: " + login() + " Id: " + id() +
        "\nUrl: " + url();
    }
}
    