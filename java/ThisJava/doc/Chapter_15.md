# Chapter 15. 컬렉션 프레임워크

>

## 15.1 컬렉션 프레임워크 소개

- 다수의 객체를 저장해 두고 필요할 때마다 꺼내서 사용하는 경우가 많음
  - 객체를 어떻게 효율적으로 추가, 검색, 삭제할 것인가?
  - 가장 간단한 방법은 배열을 이용하는 것
- 배열을 사용했을 경우 생기는 문제점
  - 저장할 수 있는 객체 수가 배열을 생성할 때 결정되기 때문에 불특정 다수의 객체를 저장하기에는 문제가 있음
  - 객체를 삭제했을 때 해당 인덱스가 비게 되어 새로운 객체를 저장하려면 어디가 비어 있는지 확인하는 코드가 필요
- 자바는 자료구조를 바탕으로 객체들을 효율적으로 추가, 삭제 검색할 수 있도록 `java.util` 패키지에 컬렉션과 관련된 인터페이스와 클래스들을 포함시켜 놓음
  - 이를 총칭해서 **컬렉션 프레임워크(Collection Framework)**라고 함
- 컬렉션 프레임워크의 주요 인터페이스 3가지
  - `List`
  - `Set`
  - `Map`
- `List`와 `Set`은 객체를 추가, 삭제 검색하는 방법에 많은 공통점이 있기에 이 인터페이스들의 공통된 메소드들만 모아 `Collection` 인터페이스로 정의하고 있음

- 인터페이스별 컬렉션 특징

| 인터페이스 분류 | 특징                                                | 구현 클래스                                  |
| --------------- | --------------------------------------------------- | -------------------------------------------- |
| List            | - 순서를 유지하고 저장<br />- 중복 저장 가능        | ArrayList, Vector, LinkedList                |
| Set             | - 순서를 유지하지 않고 저장<br />- 중복 저장 안 됨  | HashSet, TreeSet                             |
| Map             | - 키와 값의 쌍으로 저장<br />- 키는 중복 저장 안 됨 | HashMap, Hashtable,<br />TreeMap, Properties |



## 15.2 List 컬렉션

- 객체를 일렬로 늘여놓은 구조를 가지고 있음
- 객체를 인덱스로 관리, 객체를 저장하면 자동 인덱스가 부여되고 인덱스로 갬색, 삭제할 수 있는 기능을 제공
- 객체 자체를 저장하는 것이 아니라 객체의 번지를 참조
- 동일한 객체 중복 저장 가능, `null` 저장 가능
- `List `인터페이스는 <u>제너릭 타입</u>, 구체적인 타입은 구현 객체를 생성할 때 결정

- 공통 메소드
  - 객체 추가
    - `boolean add(E e)` : 주어진 객체를 맨 끝에 추가
    - `void add(int index, E element)` : 주어진 인덱스에 객체를 추가
    - `set(int inddex, E element)` : 주어진 인덱스에 저장된 객체를 주어진 객체로 바꿈
  - 객체 검색
    - `boolean contains(Object o)` : 주어진 객체가 저장되어 있는지 여부
    - `E get(int index)` : 주어진 인덱스에 저장된 객체를 리턴
    - `isEmpty()`
    - `int size()`
  - 객체 삭제
    - `void clear()` : 모든 객체 삭제
    - `E remove(int index)`
    - `boolean remove(Object o)`

### ArrayList

- `List` 인터페이스의 구현 클래스
- 일반 `배열`과 `ArrayList`는 인덱스로 객체를 관리한다는 점에서는 유사하지만 큰 차이가 있음
  - `배열` : 생성할 때 크기가 고정되고 사용 중에 크기를 변경할 수 없음  
  - `ArrayList` : 저장 용량(capacity)을 초과한 객체들이 들어오면 자동적으로 저장 용량이 늘어남

- `ArrayList`는 모든 종류의 객체를 저장할 수 있다.
  - 객체가 저장될 때 `Object` 타입으로 변환되어 저장되기 때문
  - 저장할 때 `Object`로 변환하고, 찾아올 때 원래 타입으로 변환해야 하기 때문에 실행 성능에 좋지 못한 영항을 끼침
  - 이러한 문제점으로 인해 `자바 5` 이후 제네릭을 도입하여 `ArrayList` 객체를 생성할 때 타입 파라미터로 저장할 객체의 타입을 지정함으로써 불필요한 타입 변환을 하지 않도록 함
- 빈번한 객체 삭제와 삽입이 일어나는 곳에서는 사용하지 않는 것이 바람직함
- 고정된 객체들로 구성된 `List`를 생성
  - `Arrays.asList(T...a)` 메소드 사용

### Vector

- `ArrayList`와 동일한 내부 구조를 가짐
- 차이점 : <u>동기화된(synchronized) 메소드로 구성</u>되어 있어 멀티 스레드가 동시에 이 메소드들을 실행할 수 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있음
- 멀티 스레드 환경에서 안전하게 객체를 추가, 삭제 할 수 있다.(**Thread Safe**)

### LinkedList

- `ArrayList`와 사용 방법은 똑같지만 내부 구조가 완전히 다름
  - `ArrayList`는 내부 배열에 객체를 저장해서 인덱스로 관리
  - `LinkedList`는 인접 참조를 링크해서 체인처럼 관리
- 특정 인덱스의 객체를 제거하면 앞뒤 링크만 변경되고 나머지 링크는 변경되지 않음(삽입도 마찬가지)
- 객체 삭제와 삽입이 빈번하게 일어나는 곳에서는 `ArrayList`보다 `LinkedList`가 좋은 성능을 발휘함

- `ArrayList`와 `LinkedList` 비교

| 구분       | 순차적으로 추가/삭제 | 중간에 추가/삭제 | 검색   |
| ---------- | -------------------- | ---------------- | ------ |
| ArrayList  | 빠르다               | 느리다           | 빠르다 |
| LinkedList | 느리다               | 빠르다           | 느리다 |



## 15.3 Set 컬렉션

- `List` 컬렉션은 저장 순서를 유지, `Set` 컬렉션은 저장 순서가 유지되지 않음
- 객체를 중복하여 저장할 수 없고 하나의 `null`만 저장할 수 있음
- 저장할 때와 찾을 때의 순서가 다를 수 있음

- `Set` 컬렉션

  - `HashSet`
  - `LinkedHashSet`
  - `TreeSet`

- 인덱스로 객체를 검색해서 가져오는 메소드가 없는 대신 `반복자(Iterator)` 제공

  - `boolean hasNext()` : 가져올 객체가 있으면 true를 리턴하고 없으면 false를 리턴

  - `E next()` : 컬렉션에서 하나의 객체를 가졍모

  - `void remove()` : Set 컬렉션에서 객체를 제거

  - ```java
    Set<String> set = ...;
    Iterator<String> iterator = set.iterator();
    // 저장된 객체 수만큼 루핑
    while(iterator.hasNext()){
        // String 객체를 하나 가져옴
        Strign str = iterator.next();
    }
    // 저장된 객체 수만큼 루핑
    while(iterator.hasNext()){
        // 가져온 객체를 제거
        String str = iterator.next();
        if(str.equals("홍길동")) {
            iterator.remove();
        }
    }
    ```

### HashSet

- 객체들을 순서 없이 저장하고 동일한 객체는 중복 저장하지 않음
- 동일한 객체란?
  - 객체를 저장하기 전, 먼저 객체의 `hashCode()` 메소드를 호출해서 해시코드를 얻음
  - 이미 저장되어 있는 객체들의 해시코드와 비교
  - 동일한 해시코드가 있다면 다시 `equals()` 메소드로 두 객체를 비교
  - `true`가 나오면 동일한 객체로 판단, 중복 저장하지 않음



## 15.4 Map 컬렉션

- `Key`와 `value`로 구성된 `Entry` 객체를 저장하는 구조를 가짐 (`Key`와 `value`는 모두 객체이다)

- 키는 중복 저장될 수 없지만 값은 중복 저장될 수 있다.

- 기존에 저장된 키와 동일한 키로 값을 저장하면 기존의 값은 없어지고 새로운 값으로 대치됨

- `Map` 컬렉션

  - `HashMap`
  - `Hashtable`
  - `LinkedHashMap`
  - `Properties`
  - `TreeMap`

- ```java
  // `Key`를 알고 있을때의 객체 하나를 추가, 찾기, 삭제 방법
  Map<String, Integer> map = ~;
  map.put("홍길동", 30);			// 객체 추가
  int score = map.get("홍길동");	// 객체 찾기
  map.remove("홍길동");			// 객체 삭제
  
  // 저장된 전체 객체를 대상으로 하나씩 얻고 싶을 경우
  // 첫 번째 방법 (KeySet() 메소드로 모든 키를 Set 컬렉션으로 얻은 다음 반복자를 통해 키를 하나씩 얻고 get() 메소드를 통해 값을 얻는다.)
  Map<K, V> map = ~;
  Set<K> keySet = map.keySet();
  Iterator<K> keyIterator = keySet.iterator();
  while(keyIterator.hasNext()) {
      K key = keyIterator.next();
      V value = map.get(key);
  }
  
  // 두 번째 방법(entrySet() 메소드로 모든 Map.Entry를 Set 컬렉션으로 얻은 다음, 반복자를 통해 Map.Entry를 하나씩 얻고 getKey()와 getValue() 메소드를 이용해 키와 값을 얻는다.)
  Set<Map.Entry<K, V>> entrySet = map.entryset();
  Iterator<Map.Entry<K, V>> entryIterator = entrySet.iterator();
  while(entryIterator.hasNext()) {
      Map.Entry<K, V> entry = entryIterator.next();
      K key = entry.getKet();
      V value = entry.getValue();
  }
  
  ```

### HashMap

- `HashMap`의 키로 사용할 객체는 `hashCode()`와 `equals()` 메소드를 재정의해서 동등 객체가 될 조건을 정해야 함
  - 동등 객체(동일한 키가 될 조건)
    - `hashCode()`의 리턴값이 같아야 함
    - `equals()` 메소드가 `true`를 리턴
- 키 타입은 주로 `String`을 많이 사용
- 키와 값으 타입은 기본 타입을 사용할 수 없고 클래스 및 인터페이스 타입만 가능

### Hashtable

- `HashMap`과 동일한 내부 구조
- `HashMap`과의 차이점
  - `Hashtable`은 동기화된(synchronized) 메소드로 구성되어 있기 때문에 멀티 스레드가 동시에 이 메소드들을 실행할 수는 없고, 하나의 스레드가 실행을 완료해야만 다른 스레드를 실행할 수 있다. (**Thread safe**)

### Properties

- `Hashtable`의 하위 클래스
- `Hashtable`의 모든 특징을 그대로 가지고 있음
- `Hashtable`과의 차이점
  - `Hashtable`은 키와 값을 다양한 타입으로 지정이 가능
  - `Properties`는 키와 값을 `String` 타입으로 제한한 컬렉션
- 애플리케이션의 옵션 정보, 데이터베이스 연결 정보, 국제화 정보가 저장된 프로퍼티 파일(`.properties`)을 읽을 때 주로 사용
  - 프로퍼티 파일을 읽기 위해서는 `Properties` 객체를 생성하고, `load()` 메소드를 호출한다.
  - `load()` 메소드는 프로퍼티 파일로부터 데이터를 읽기 위해 `FileReader` 객체를 매개값으로 받는다.
  - 프로퍼티 파일은 일반적으로 클래스 파일(~.class)과 함께 저장됨

```java
// 키 = 값으로 구성된 프로퍼티(database.properties)
driver=oracle.jdbc.OracleDriver
url=jdbc:oracle:thin:@localhost:1521:orc1
username=scott
password=tiger

// 프로퍼티 파일 경로를 이용하여 데이터 읽기
Properties properties = new Properties();
properties.load(new FileReader("C:/~/database.properties"));

// 프로퍼티 파일 경로 얻기
String path = 클래스.class.getResource("database.properties").getPath();
// .getResource는 주어진 파일의 상대 경로를 URL 객체로 리턴
// .getPath()는 파일의 절대 경로를 리턴해줌
path = URLDecoder.decode(path, "utf-8");	// 경로에 한글이 있을 경우 한글 복원
Properties properties = new Properties();
properties.load(new FileReader(path));

// Properties 객체에서 해당 키의 값을 읽기
String value = properties.getProperty("key");
```

