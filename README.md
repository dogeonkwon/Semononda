# 세모논다(semononda)

![대표이미지](https://user-images.githubusercontent.com/99178653/187210792-d736596e-8488-47d3-9b0f-d6dfd58c5ced.PNG)

## 링크 : [세모논다 홈페이지](http://i7e103.p.ssafy.io/)

## 소개 영상 : [소개 영상 링크]()



## 📘 프로젝트 진행 기간

2022.07.04(월) ~ 2022.08.19(금)
SSAFY 7기 2학기 공통 프로젝트 - 세모논다

</br>

## 🏅 세모논다 - 배경

우리가 사는 세상에는 많은 논쟁들과 의견들이 있습니다.

당신은 상대방의 의견을 잘 받아들이고 있나요?

자신의 의견을 주장할 뿐만 아니라 상대방의 의견에도 공감 할 수 있는 사고력을 기를 수 있는 서비스!

**세모논다 함께 시작해보세요.**

</br>

## 🔎 세모논다 - 개요

_- 전국 최초 논쟁 플랫폼 -_

**세모논다**는 "세상의 모든 논쟁을 다룬다"의 약자입니다.

깻잎 논쟁 같은 논쟁부터 한국인이라면 누구나 고민할만한 이슈에 대해 서로 의견을 내보고 결론을 내릴 기회를 제공합니다.

게임의 전체적인 배경은 조선 시대이며 왕의 역할을 맡은 플레이어와, 한 주제에 대한 다른 의견을 가진 신하 진영을 맡은 플레이어가 논쟁을 진행합니다.

플레이어들은 공식 경연과 공식 경연 두 가지 종류의 게임 중 자유롭게 선택해 플레이할 수 있습니다.

공식 경연은 사용자가 무작위의 사람들과 한 주제 카테고리를 가지고 토론하게 됩니다. 게임을 이길시에 랭킹포인트를 지급하며, 해당 주제에 대한 게임 결과는 서버에 저장되어 다른 사용자들이 확인할 수 있습니다.

자유 경연은 친구들과 즐길 수 있는 모드로, 플레이어들이 직접 주제를 정해서 그 주제를 가지고 게임을 플레이할 수 있습니다.

</br>

## ⚖ 게임 규칙

- #### 역할
  - 왕
    - 게임의 사회자 역할과 최종 승리 진영을 선택하는 역할을한다.
    - 신하들의 발언을 종합하여 3분 안에 승리 진영을 선택한다.
    - 라운드가 끝날 때 보유한 금화가 2개 이상인 신하 중에서 다음 라운드의 왕이 선정되며 그런 신하가 여럿일 시에 그 중에서 랜덤으로 선정한다.
    - 왕은 신하들의 원만한 소통을 위한 발언을 제재할 수 있다. (캠 끄기, 음소거 시키기)
  - 신하
    - 논쟁에 대한 입장을 랜덤으로 배정받는다.
    - 왕이 해당 진영을 선택할 수 있도록 왕을 설득하여야 한다.
    - 승리 진영으로 선택되면 해당 진영의 모든 신하는 금화를 하나 하사 받는다.
- #### 진행
  - 공식 경연
    - 하나의 주제 카테고리 안에서 매 라운드마다 랜덤한 주제가 선정된다.
    - 처음 턴의 왕과 금화를 보유한 신하가 충분치 않을 시에는 왕을 랜덤으로 선정한다.
    - 랜덤으로 선정된 왕은 금화 취득에 패널티를 받는 것이기 때문에 추가 랭크 포인트를 부여한다.
    - 신하나 왕은 상대방의 진영이 무엇인지 알 수 없다.
    - 랜덤왕이 아닌 일반왕으로 2번 선정된 왕이 발생할 시에 해당 플레이어의 우승으로 게임을 종료한다.
    - 게임이 종료될 시에는 해당 게임에서 취득한 금화의 총 개수에 비례하여 랭크 포인트를 부여하고, 최종 우승자에게는 추가 랭크 포인트를 부여한다.
  - 자유 경연
    - 플레이어들이 선정한 주제로 게임을 진행할 수 있으며, 단판 라운드로 게임이 진행된다.
    - 게임 결과와 상관없이 랭크포인트를 부여하지 않는다.
    - 자유 경연에서의 왕은 방장으로 자동 선정된다.

---

</br>

## ✔ 주요 기술

---

**Backend**

- Springboot
- Spring Data JPA
- Spring Security
- Spring Validation
- Spring Web
- Query DSL
- Swagger
- Gradle
- MySQL

**Frontend**

- React
- openVidu browser
- HTML
- JavaScript
- CSS

**CI/CD**

- AWS EC2
- NGINX
- SSL
- Docker
- Jenkins
- openVidu KMS

---

## ✔ 프로젝트 파일 구조

---

### Frontend

```
frontend
├─public
└─src
    ├─app
    ├─assets
    │  ├─fonts
    │  └─images
    ├─common
    │  ├─api
    │  ├─modal
    │  └─navbar
    └─features
        ├─custom
        │  └─page
        ├─game
        ├─gossip
        │  └─page
        ├─help
        │  └─page
        ├─home
        │  └─page
        ├─mypage
        │  └─page
        ├─notfound
        ├─rank
        │  └─page
        ├─statistic
        │  └─page
        ├─user
        │  └─page
        └─userrank
            └─page

```

### Backend

```
backend
├─.gitlab
│  └─merge_request_templates
├─.gradle
│  ├─6.7
│  │  ├─fileChanges
│  │  ├─fileHashes
│  │  └─vcsMetadata-1
│  ├─buildOutputCleanup
│  ├─checksums
│  ├─configuration-cache
│  └─vcs-1
├─.settings
├─bin
│  └─main
│      ├─com
│      │  └─ssafy
│      │      ├─api
│      │      │  ├─controller
│      │      │  ├─request
│      │      │  ├─response
│      │      │  └─service
│      │      ├─common
│      │      │  ├─auth
│      │      │  ├─exception
│      │      │  │  └─handler
│      │      │  ├─model
│      │      │  │  └─response
│      │      │  └─util
│      │      ├─config
│      │      ├─db
│      │      │  ├─entity
│      │      │  ├─qentity
│      │      │  └─repository
│      │      └─infos
│      └─dist
│          ├─css
│          ├─fonts
│          ├─img
│          └─js
├─gradle
│  └─wrapper
└─src
    └─main
        ├─java
        │  └─com
        │      └─ssafy
        │          ├─api
        │          │  ├─controller
        │          │  ├─request
        │          │  ├─response
        │          │  └─service
        │          ├─common
        │          │  ├─auth
        │          │  ├─exception
        │          │  │  └─handler
        │          │  ├─model
        │          │  │  └─response
        │          │  └─util
        │          ├─config
        │          ├─db
        │          │  ├─entity
        │          │  ├─qentity
        │          │  └─repository
        │          └─infos
        └─resources
            └─dist
                ├─css
                ├─fonts
                ├─img
                └─js
```

## ✔ 협업 툴

---

- [Gitlab](https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103)
- [Notion](https://www.notion.so/Semononda-26223a897b784d8d88ec1e02a79df4b2)
- [JIRA](https://jira.ssafy.com/secure/RapidBoard.jspa?rapidView=12719&projectKey=S07P12E103&view=planning.nodetail&issueLimit=100)
- [Figma](https://www.figma.com/file/RXpNubjb9F9pGdmKwbLVOk/%EC%84%B8%EB%AA%A8%EB%85%BC%EB%8B%A4?node-id=0%3A1)
- [MatterMost](https://meeting.ssafy.com/s07p11e1/channels/333)
- [Webex](https://ssafyclass.webex.com/meet/kjmk1007)

## ✔ 협업 환경

---

- 요구사항 명세서/IA 구성도/API 명세서
  - [구글 드라이브](https://docs.google.com/spreadsheets/d/1Szz6Hn31rGLiAI0DS68rMQKO8MfN0WhXfXgDKB41ufs/edit#gid=0)에서 기획 내용을 공유 및 수정
- Gitlab
  - 코드 버전 관리
  - MR 템플릿 사용
  - 기능별 branch 생성, 개발.
  - 커밋 컨밴션 Udacity convention 사용
- JIRA
  - 개발 기획에 따라 에픽, 이슈 생성
  - 매주 첫 워킹데이에 개인 목표량을 설정하여 Sprint 진행
  - 업무의 우선순위를 설정하고, 할당량을 정하여 Story Point를 설정한 뒤 In-Progress -> Done 순으로 작업
  - 소멸 차트를 통해 스프린트 진척도 확인
- 회의
  - 매일 아침 스크럼 진행, 진행 중인 내용 및 이슈 공유
  - 프론트엔드 <-> 백엔드 요구사항 소통
  - 팀원 칭찬 타임
  - 매일 오후 스크럼 진행, 오늘 진행한 내용 공유
- Notion
  - 회의록/피드백/스크럼/상담내용 등 저장
  - 개발 참고 자료 업로드, 필요 개념 공유
  - 개발 도중 발생한 이슈 저장
  - 컨벤션 정리
  - 각종 명세서 등 모두가 공유해야 하는 문서 관리
- Figma
  - 목업 제작, 와이어프레임제작, 디자인 작업 공유

## ✔ 팀원 역할 분배

---

|   Name   | 강병수                                                       | 권도건                                                       | 정찬우                                                       | 김동우                                                       | 김유정                                                       | 박찬호                                                       |
| :------: | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| Profile  | ![수정됨_강병수](https://user-images.githubusercontent.com/99178653/187210832-cf776770-472e-4c83-835f-23a3840a0f9c.png) | ![수정됨_권도건](https://user-images.githubusercontent.com/99178653/187210875-24696691-640c-45f4-8595-c8bfbd4d2d78.png) | ![수정됨_정찬우](https://user-images.githubusercontent.com/99178653/187210882-9b5acab5-6bb0-49ac-bbb0-557841d39667.png) | ![수정됨_김동우](https://user-images.githubusercontent.com/99178653/187210889-09f1c09a-062f-4f4f-b14b-6d5370d0d671.png) | ![수정됨_김유정](https://user-images.githubusercontent.com/99178653/187210916-5b4f8cf2-5533-476e-a58c-e13eb2cb6337.png) | ![수정됨_박찬호](https://user-images.githubusercontent.com/99178653/187210911-00221ca2-6ffa-487f-ab4e-731d3fc3ad04.png) |
| Position | Frontend & UI/UX                                             | 팀장 & Frontend & UI/UX                                      | Frontend & UI/UX                                             | Backend Develop & CI/CD & UCC                                | Backend Develop & CI/CD & UI/UX                              | Backend Develop & CI/CD & openVidu                           |
|   Git    | [kang-byung-soo](https://github.com/kang-byung-soo)          | [doogun](https://github.com/doogun)                          | [jeong-chan](https://github.com/jeong-chan)                  | [ehddn5252](https://github.com/ehddn5252)                    | [yujeonge](https://github.com/yujeonge)                      | [taurus429](https://github.com/taurus429)                    |

## ✔ 설계 산출물

---

- [설계 문서](https://docs.google.com/spreadsheets/d/1Szz6Hn31rGLiAI0DS68rMQKO8MfN0WhXfXgDKB41ufs/edit#gid=0)
  - 요구사항 정의서
  ![요구사항](https://user-images.githubusercontent.com/99178653/187211119-f5e0ab59-06f7-4ec6-961b-bfe9df26a231.PNG)
  - IA 구성도
  ![IA구성도](https://user-images.githubusercontent.com/99178653/187211046-32060057-804a-4bcf-bf50-9d8f79bd90f0.PNG)
  - API 명세서
  ![API명세서](https://user-images.githubusercontent.com/99178653/187211051-9d83a077-a78b-44b0-a29e-89d0a805d780.PNG)
  
  
  
- [디자인&컨셉기획](https://www.figma.com/file/RXpNubjb9F9pGdmKwbLVOk/%EC%84%B8%EB%AA%A8%EB%85%BC%EB%8B%A4?node-id=0%3A1)
  ![와이어프레임](https://user-images.githubusercontent.com/99178653/187211057-934abeff-ade4-4f43-bd95-24627d985cec.PNG)

- 플로우 차트
  ![Untitled__7_](https://user-images.githubusercontent.com/99178653/187211086-dedfd221-5ad9-4ff7-b84c-edf025107eb1.png)

- 사이트 맵
  ![Untitled__6_](https://user-images.githubusercontent.com/99178653/187211082-f380c579-9c30-40f9-9e31-9555fe8e5d3b.png)

- ERD
![20220722_Database_structure](https://user-images.githubusercontent.com/99178653/187211083-b7e5a5e8-1138-4028-add4-2ce05c471179.png)

## ✔ 프로젝트 결과물
---
## 포팅메뉴얼
---
### AWS EC2 기본 설정
#### MobaXterm 설치

- 다음 링크에서 MobaXterm Home Edition v22.1 (Portable edition) (2022.07.26 기준) 설치 받기

[MobaXterm free Xserver and tabbed SSH client for Windows](https://mobaxterm.mobatek.net/download-home-edition.html)

#### EC2 접속

1. 우측 상단 Session 클릭

![Untitled](https://user-images.githubusercontent.com/99178653/187211469-4e890978-4ff8-4314-aa66-453242313442.png)

1. SSH 클릭 후 정보 입력
- 입력 정보
  
    Remote host : [i7e103.p.ssafy.io](http://i7e103.p.ssafy.io/)
    
    Specify username : ubuntu
    
    User Private Key : 다운받은 pem파일

![Untitled__1_](https://user-images.githubusercontent.com/99178653/187211473-301bdb55-c895-452b-a6a1-0c0945b24555.png)


#### 방화벽 설정

- UFW(Uncomplicated Firewall)사용

```
# 현재 방화벽 상태 확인 방법 입니다.
$ sudo ufw status
```
![Untitled__2_](https://user-images.githubusercontent.com/99178653/187211477-1f3bd05b-a916-4d2d-8fc2-002bb081b90e.png)

```
# Port 설명입니다.
22 : cmd로 접속 할 수 있게 해주는 포트
3306 : MySQL을 사용하기 위한 포트

#서버 배포 후 열어야 할 포트입니다.
8080 : back
3000 : front

#Port 여는 방법입니다.
$ sudo ufw allow 8080
$ sudo ufw enable
```

#### DB 설치 (My SQL)

```
# MySQL을 설치합니다.
$ sudo apt-get update
$ sudo apt-get install mysql-server #진행 중에 Y

# 설치 완료 후 접속합니다.
$ sudo mysql
```
--- ### openVidu 배포
#### Docker 설치

- Docker version 20.10.17 (2022.07.26 기준)

```
# apt 패키지를 업데이트하고 하위 패키지를 설치합니다.
$ sudo apt-get update
$ sudo apt-get install \ ca-certificates \ curl \ gnupg \ lsb-release

# Docker’s official GPG key를 추가합니다.
$ sudo mkdir -p /etc/apt/keyrings $ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg

# 레파지토리를 만들어줍니다.
$ echo \ "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \ $(lsb_release -cs) stable" | sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

# 도커 엔진을 설치합니다.
$ sudo apt-get update
$ sudo apt-get install docker-ce docker-ce-cli containerd.io docker-compose-plugin
```

#### Docker Desktop 이미지 다운로드

- 다음 링크에서 ‘DEB’를 클릭해서 다운로드 받습니다.

[https://docs.docker.com/desktop/install/linux-install/](https://docs.docker.com/desktop/install/linux-install/)

#### **aws EC2 instance 실행 및 보안설정**

다음 포트들을 열어줍니다.

```
22 TCP
80 TCP
443 TCP
3478 TCP와 UDP
=======
3306 MySQL을 위한 포트
```

![Untitled__3_](https://user-images.githubusercontent.com/99178653/187211482-530ca49f-f6cb-4f9c-8108-4e1cd105cce6.png)

#### **Filezilla로 다운로드 한 Docker 이미지를 업로드**

![Untitled__4_](https://user-images.githubusercontent.com/99178653/187211458-d7ed595d-c46e-4d6b-a5db-e1e053215d72.png)

#### **터미널로 EC2 접근 & Docker Desktop 설치**

- EC2에 연결 된 터미널에서 해당 코드를 실행합니다.

```
$ sudo apt-get update

# 해당 이미지가 있는 위치로 이동 한 뒤dock까지만 한 뒤 tab하기
$ sudo apt-get install ./dock
```

#### **openvidu 배포**

- 참고 : [https://docs.openvidu.io/en/2.22.0/deployment/ce/on-premises/](https://docs.openvidu.io/en/2.22.0/deployment/ce/on-premises/)

```
$ sudo su
$ cd /opt
$ curl https://s3-eu-west-1.amazonaws.com/aws.openvidu.io/install_openvidu_latest.sh | bash
$ cd openvidu
$ nano .env  #해당 명령어를 입력하면 설정파일이 열림
```
![Untitled__5_](https://user-images.githubusercontent.com/99178653/187211465-0aac7b1f-86ed-462c-a247-700da9d8ad16.png)

```
#수정해야 할 항목입니다.

DOMAIN_OR_PUBLIC_IP=[i7e103.p.ssafy.io](http://i7e103.p.ssafy.io/)  #도메인
OPENVIDU_SECRET=321fyass               #비밀번호
CERTIFICATE_TYPE=letsencrypt
LETSENCRYPT_EMAIL=원하는 이메일 주소
```

```
./openvidu start  #실행하기
```
## 👔 발표 자료
---
- [중간발표자료](https://docs.google.com/presentation/d/12lam9rB1swFsq4DB1aSVrL0iuVCa2Axr/edit#slide=id.p1)
- [최종발표자료]()
---

## 🎵 세모논다 서비스 화면

---

### 메인화면
![이미지_2](https://user-images.githubusercontent.com/99178653/187211653-4825f2a9-aa05-415d-a744-f0cb71885fa1.png)
### 회원가입
![이미지_12](https://user-images.githubusercontent.com/99178653/187211655-7793f88b-a93e-483d-8ab5-d4c70de7bc01.png)
### 개인정보창
![이미지_3](https://user-images.githubusercontent.com/99178653/187211659-9838227e-f4e2-412d-a7ae-57bd5f179264.png)
### 개인정보 수정
![이미지_4](https://user-images.githubusercontent.com/99178653/187211671-7c912709-9273-42f1-bcf2-5a50deb3aaaa.png)
### 비밀번호 수정
![이미지_5](https://user-images.githubusercontent.com/99178653/187211638-e98289cb-1dd0-4260-ba8d-7e579d96e0be.png)
### 자유경연방 생성
![이미지_6](https://user-images.githubusercontent.com/99178653/187211644-38e50688-cbbe-4157-8f16-41725401ec01.png)
![이미지_7](https://user-images.githubusercontent.com/99178653/187211647-33149e9c-ad99-492f-b0fb-fbc4701f7a2a.png)

### 자유경연방 목록
![이미지_8](https://user-images.githubusercontent.com/99178653/187211650-fd87ddba-146b-4f5a-bc6e-410cbdd2de89.png)
### 공식경연방 생성
![이미지_9](https://user-images.githubusercontent.com/99178653/187211651-8981095a-17d6-4ccb-b699-f5828ea52f6a.png)
### 공식경연방 목록
![이미지_2 (1)](https://user-images.githubusercontent.com/99178653/187211849-215cb3a7-7057-4022-b6d0-dc82f013f0e8.png)
### 공식경연 게임 화면
![KakaoTalk_20220819_112203643](https://user-images.githubusercontent.com/99178653/187211855-6dfa1d30-a24d-4738-974e-4d3f5167da17.gif)
### 신하 순위
![이미지_10](https://user-images.githubusercontent.com/99178653/187211865-eac7b673-3aca-4bc1-a1c0-237436d9c613.png)
### 주제별 통계
![KakaoTalk_20220819_110339445](https://user-images.githubusercontent.com/99178653/187211867-fa729d55-8a35-4285-8509-d5ae0ac5df25.png)
### 도움말
![KakaoTalk_20220819_115521761](https://user-images.githubusercontent.com/99178653/187211871-525f5d02-4f76-4965-87f0-6edab202d4f5.png)

![KakaoTalk_20220819_115507748](https://user-images.githubusercontent.com/99178653/187211874-2625de0b-a71f-4683-acf9-da561fffa486.png)


