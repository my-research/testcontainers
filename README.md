# testcontainers

## 시나리오 1.

#### Spring Application 인 `todo-application` 에 대한 integration test 를 지원하라

- `todo-application`
  - spring application
  - POST, GET(단건, 복수) api 를 지원한다
- `integration-tests`
  - todo-application 에 대한 3가지 api 에 대해서 regression test 를 할 수 있도록 한다

### constraint

- 3개의 테스트 케이스가 나와야 한다
- 모든 테스트는 다른 테스트에 영향을 주어서는 안된다

### References

- [testcontainers, docs](https://www.testcontainers.org/features/creating_container/)
- [localstack, docs](https://docs.localstack.cloud/overview/)
