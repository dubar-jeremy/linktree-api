CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE pages (
                       id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                       title VARCHAR(255) NOT NULL,
                       slug VARCHAR(100) NOT NULL UNIQUE,
                       description TEXT,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE links (
                       id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
                       page_id UUID NOT NULL,
                       label VARCHAR(255) NOT NULL,
                       url TEXT NOT NULL,
                       position INTEGER DEFAULT 0,
                       created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,

                       CONSTRAINT fk_page FOREIGN KEY (page_id) REFERENCES pages(id) ON DELETE CASCADE
);