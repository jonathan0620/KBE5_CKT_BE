## 🚗 차칸팀 차량 관제 시스템
차량 관제 및 예약 관리 통합 시스템은 렌터카 및 공유 차량의 실시간 위치 추적, 운행 상태 모니터링, 시동 ON/OFF 이벤트 처리, 예약 기반 운행 일지 생성 등 다양한 기능을 통합적으로 제공하는 플랫폼입니다. 
차량 단말기와 서버 간 실시간 연동을 기반으로, 차량의 상태를 정확히 파악하고 효율적으로 관리할 수 있도록 설계되었습니다.
<br />
<br />
📆 2025.05 ~ 2025.07
<br />
<br />
## 🎬 시연 영상

## 🚀 기능 설명
### 1. 실시간 관제

- 실시간 **전체 차량의 수량**을 확인할 수 있습니다.
    - 전체 차량의 개수
    - 운행 중인 차량의 개수
    - 미 운행중인 차량의 개수
    - 도난 차량의 개수 → 업데이트 예정
- **운행 중인 차량 목록**에 현재 **운행 중인 차량**의 목록을 확인할 수 있습니다.
    - 차량 번호를 검색하여 운행 중인 차량 중에 해당하는 차량의 목록만 확인할 수 있습니다.
    - 목록에서 차량을 선택하면, 해당 차량의 위치를 기준으로 지도를 zoom 하여 확대 및 이동해 줍니다.
- **지도**를 통해 현재 **운행 중인 차량의 위치**를 실시간으로 파악할 수 있습니다.
    - 지도 상의 차량을 선택하면, 해당 차량의 상세 정보를 확인할 수 있습니다.
- **예약을 진행하지 않고 시동이 된 차량은 도난 차량으로 분류가 됩니다.**
<br />

### 2. 운행 일지

- 차량의 운행 기록 목록을 조회할 수 있습니다.
    - 차량 번호 및 원하는 기간으로 필터링 하여 목록을 조회할 수 있습니다.
- 차량의 운행 기록의 상세 내용을 확인할 수 있습니다.
<br />

### 3. 통계

- **월별 운행 통계**를 확인할 수 있습니다.
    - 전체 **총 운행거리**, **총 운행시간**, **운행 횟수**를 확인할 수 있습니다.
- 조회한 날짜의 **차량별 운행 정보**를 확인할 수 있습니다.
- 선택한 차량의 **운행 기록을 엑셀로 다운로드** 할 수 있습니다.
- 차량별 운행 내역에서 **차량을 선택**하여, **차량의 주간 운행 그래프를 확인**할 수 있습니다.
- 차량의 **주간 운행 그래프의 N주차를 선택**하여, **차량의 일별 운행 그래프를 확인**할 수 있습니다.
<br />

### 4. 차량 관리

- 로그인한 **업체의 차량을 관리**합니다.
- 차량을 **등록, 수정, 삭제**할 수 있습니다.
- 차량의 **상세 정보**를 확인할 수 있습니다.
    - 등록 정보 및 차량의 현재 위치
<br />

### 5. 사용자 관리

- 로그인한 **업체의 사용자를 관리**합니다.
- 사용자를 고객 및 법인으로 **등록, 수정, 삭제**할 수 있습니다.
- 고객의 상세 정보를 확인할 수 있습니다.
<br />

### 6. 예약 관리

- 업체가 관리하는 차량을 다른 서비스 혹은 고객센터 문의를 통해 **예약을 받았다고 가정**하고, **관리자에서 직접 등록**하여 사용하는 예약 페이지 입니다.
- 우리 서비스에서는 **예약을 하지 않고, 운행하는 차량은 도난 차량으로 분류**가 되고 있습니다.
- 예약을 하지 않아도 차량의 운행일지와 실시간 관제에는 **도난된 차량의 추적**을 위해 운행 정보를 확인할 수 있습니다.
- **예약 등록**
    - **사용자**가 원하는 **차량을 원하는 시간대에 예약**을 할 수 있습니다.
        - 현재 서비스에서는 **관리자가 등록**할 수 있도록 되어 있습니다.
- **사용자가 차량 수령 (’예약 대기’ → ‘예약 중’)**
    - 사용자가 차량을 예약한 후 **실제로 차량을 수령**할 때, 변경되는 상태입니다.
- **차량 예약을 취소 (’예약 대기’ → ‘예약 취소’)**
    - 사용자가 **예약을 취소**할 때, 변경되는 상태입니다.
- **차량 반납 (’예약중’ → ‘예약 반납’)**
    - 사용자가 **운행을 종료하고 차량을 반납**할 때, 변경되는 상태입니다.
    - 정상 운행의 경우 예약 반납을 하면, 해당 차량의 운행일지가 생성됩니다.
<br />

### 7. 애뮬레이터

- 차량의 시동 ON 과 시동 OFF 기능을 지원합니다.
- 시동 ON 시 실시간 차량 관제 페이지에서 해당하는 차량을 관제할 수 있습니다.
- 예약을 하지 않고 시동 ON을 하는 경우 해당 차량은 **도난 차량**으로 분류가 됩니다.
- 예약을 하고 시동 ON → 시동 OFF를 하는 경우 해당 **예약을 반납**하기 전까지 운행일지의 **ON → OFF 당 하나의 ‘경로’로 구분**되어 여러가지 경로를 운행일지에 함께 저장합니다.
<br />
<br />

## ⚙ 기술 스택
### Front-end
<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=white"> <img src="https://img.shields.io/badge/AWS%20Amplify-FEDB00?style=for-the-badge&logo=awsamplify&logoColor=black">
<br />

### Back-end
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=OpenJDK&logoColor=white"> <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"> <img src="https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white"> <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL&logoColor=white"> <img src="https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=RabbitMQ&logoColor=white"> <img src="https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white"> <img src="https://img.shields.io/badge/grafana-%23F46800.svg?style=for-the-badge&logo=grafana&logoColor=white">
<br />

### Infra
<img src="https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white"> <img src="https://img.shields.io/badge/AWS%20EC2-FF9900?style=for-the-badge&logo=AWS%20EC2&logoColor=white"> <img src="https://img.shields.io/badge/AWS%20ECR-FF9900?style=for-the-badge&logo=AWSaws&logoColor=white">
<img src="https://img.shields.io/badge/AWS%20ECS-FF9900?style=for-the-badge&logo=AWSaws&logoColor=white">
<img src="https://img.shields.io/badge/AWS%20CloudWatch-FF4F8B?style=for-the-badge&logo=AWSaws&logoColor=white">
<br />
<br />

## 🛠️ 프로젝트 아키텍처
<img width="640" height="399" alt="Image" src="https://github.com/user-attachments/assets/3aa93c11-107f-4844-b680-a8f4fe718faf" />
<br />
<br />

## 🗂️ ERD
![Image](https://github.com/user-attachments/assets/5f64fd24-d4c1-419e-84ff-bf2f5fbd50ad)
