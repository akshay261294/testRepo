package com.test;

import java.util.Map;

public class Gist {
    private String url;
    private String id;
    private Map<String, File> files;
    private boolean publicGist; // Changed to avoid conflict with `public` keyword
    private String createdAt;
    private String updatedAt;
    private String description;
    private Owner owner;

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<String, File> getFiles() {
        return files;
    }

    public void setFiles(Map<String, File> files) {
        this.files = files;
    }

    public boolean isPublicGist() {
        return publicGist;
    }

    public void setPublicGist(boolean publicGist) {
        this.publicGist = publicGist;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    // Nested File class
    public static class File {
        private String filename;
        private String type;
        private String language;
        private String raw_url;
        private int size;

        // Getters and Setters
        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getRawUrl() {
            return raw_url;
        }

        public void setRawUrl(String raw_url) {
            this.raw_url = raw_url;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }

    // Nested Owner class
    public static class Owner {
        private String login;
        private int id;
        private String html_url;

        // Getters and Setters
        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getHtmlUrl() {
            return html_url;
        }

        public void setHtmlUrl(String html_url) {
            this.html_url = html_url;
        }
    }

    @Override
    public String toString() {
        return "{" +
                "url='" + url + '\'' +
                ", id='" + id + '\'' +
                ", files=" + files +
                ", publicGist=" + publicGist +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                '}';
    }

}

