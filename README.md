## Prerequisites

Before running the project make sure you have:

- Java 21 installed
- Maven installed
- Ollama installed
- Llama3 or any supported model downloaded

## Ollama Setup

Start Ollama:

```bash
ollama serve
```

Run model:

```bash
ollama run llama3
```

Verify Ollama:

```bash
curl http://localhost:11434/api/tags
```

## Application Configuration
 ### application.yaml
```yaml
spring:
  ai:
    ollama:
      base-url: http://localhost:11434
      chat:
        model: llama3
```
  ### application.properties
```Properties
  spring.ai.ollama.base-url=http://localhost:11434
  spring.ai.ollama.chat.model=llama3
```

## API Endpoints

### Chat API

```http
GET /ai/chat?message=hello
```

Example:

```http
http://localhost:8088/ai/chat?message=what%20is%20weather%20in%20bangalore
```

## Sample Response

Request:

```http
GET /ai/chat?message=What is AI?
```

Response:

```json
Artificial Intelligence (AI) refers to...
```


## Future Enhancements

- RAG implementation
- Vector database integration
- AI agents
- Multi-modal support
- Voice assistant integration
- Kafka event processing
- Tool calling support
- Authentication & authorization
- Conversation persistence


## Learning Outcomes

- Spring AI integration
- Local LLM orchestration
- AI + microservices architecture
- Prompt engineering
- Session management
- REST API design


## Author

Abhinandan

