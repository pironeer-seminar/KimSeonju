package pironeer;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import pironeer.util.Reader;
import pironeer.util.Timer;

public class DetectiveGame {

    private List<Character> characters;
    private Character murderer;                         // 살인자
    private Character victim;                           // 희생자
    private String dyingMessage;
    private Character suspect;                          // 용의자
    private int lives;                                  // 기회
    private String detectiveName;

    private final Reader reader = new Reader();
    private final Timer timer = new Timer();
    private final Random random = new Random();

    public void init() {
        characters = new ArrayList<>();
        characters.add(new Character("최승호", "장발이야", "운동복을 입었어", "나이키를 신었어"));
        characters.add(new Character("김민수", "파란 모자를 썼어", "양복을 입었어", "구두를 신었어"));
        characters.add(new Character("이건희", "파마를 했어", "무스탕을 입었어", "아무것도 안 신고 있었어"));
        characters.add(new Character("손관우", "스님 머리야", "셔츠를 입었어", "슬리퍼 신었어"));
        characters.add(new Character("장지요", "단발머리야", "치마를 입었어", "부츠를 신었어"));
        characters.add(new Character("안시환", "투블럭을 했어", "반팔티를 입었어", "크록스를 신었어"));
        characters.add(new Character("이지현", "허리까지 머리카락이 있어", "원피스를 입었어", "힐을 신었어"));
        lives = 2;
    }

    // showIntro
    public void showIntro() {
        inputDetectiveName();
        selectVictimAndMurderer();
        generateDyingMessage();
        printStoryStart();
        printCrimeScene();
        printInvestigationStart();
    }

    public void inputDetectiveName() {
        System.out.println("탐정 게임에 오신 것을 환영합니다.");
        timer.sleep(1000);

        // 4. Reader 클래스를 사용하여 탐정의 이름을 입력받고 1.5초 정지
        System.out.print("탐정의 이름을 입력해주세요:");
        detectiveName = reader.nextLine().trim();                       // 입력 받기 (공백제거)
        timer.sleep(1500);
    }

    public void selectVictimAndMurderer() {
        // 5. 캐릭터 중 한 명을 희생자로 지정하고, 목록에서 제거
        victim = characters.get(random.nextInt(characters.size()));    // 희생자 지정
        characters.remove(victim);                                     // 목록에서 제거
        murderer = characters.get(random.nextInt(characters.size()));  // random.nextInt(characters.size())는 0부터 characters.size() - 1 사이의 무작위 정수를 생성
    }

    public enum DyingMessageType {
        HAIR("머리스타일은"), CLOTHES("옷은"), SHOES("신발은");             // 대문자로 표기하는 것이 일반적

        private final String message;

        DyingMessageType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public String getMurdererAttribute(DyingMessageType type) {
        return switch (type) {
            case HAIR -> murderer.getHair();
            case CLOTHES -> murderer.getClothes();
            case SHOES -> murderer.getShoes();
        };
    }

    public void generateDyingMessage() {
        DyingMessageType[] values = DyingMessageType.values();
        DyingMessageType selectedType = values[random.nextInt(values.length)];

        dyingMessage = selectedType.getMessage() + " " + getMurdererAttribute(selectedType) + " 윽..☠";

    }

    public void printStoryStart() {
        System.out.println("########################################");
        System.out.println("#######        평화로운 해커톤              ");
        System.out.println("########################################");
        timer.sleep(1500);

        System.out.println("\n코딩에 몰두하던 " + detectiveName + ", 눈이 피로해지기 시작한다. 해커톤의 열기가 고조될수록, 정신은 점점 흐릿해진다.");
        timer.sleep(1000);
        System.out.println(detectiveName + ": 이 해커톤, 너무 평화롭기만 하군... 뭔가 재밌는 사건이라도 터져야 할 텐데. 뭐, 코드가 몽땅 날아가는 일이라든지.");
        timer.sleep(1000);
        System.out.println(victim.getName() + ": 하하, 탐정님! 그런 무서운 말씀은 제발 그만하세요. 상상만 해도 아찔하네요... 그런 일은 절대로 일어나지 않을 거예요.");
        timer.sleep(1000);
        System.out.println(detectiveName + ": 뭐, 그렇긴 하겠지. 아, 참고로 나는 명탐정 " + detectiveName + "! 사건이 터지면 언제든 나를 찾아.");
        timer.sleep(1000);
        System.out.println(victim.getName() + ": 하하, 명탐정님! 알겠습니다. 그런데 요즘 제 노트북을 자꾸 누가 훔쳐보는 것 같아서 신경 쓰이긴 해요. 집 앞 카페에서 코딩하다 보면 말이죠...");
        timer.sleep(1000);
        System.out.println("그렇게 둘은 헤어졌고, 그로부터 10분 후 갑자기 정전이 일어나게 되는데..\n");
        timer.sleep(1000);
    }

    public void printCrimeScene() {
        System.out.println("########################################");
        System.out.println("#######        사건 발생             ");
        System.out.println("########################################");
        timer.sleep(1000);

        System.out.println("\n갑자기 날카로운 비명 소리가 울려 퍼졌다. " + victim.getName() + "씨의 노트북 화면이 순식간에 블루스크린으로 바뀌었다.");
        timer.sleep(1000);
        System.out.println("그 충격에 " + victim.getName() + "씨는 정신을 잃고 그대로 쓰러졌다...");
        timer.sleep(1000);

        System.out.println("\n현장은 순식간에 혼란에 빠졌고, 바닥에는 " + victim.getName() + "씨의 메시지가 남겨져 있었다.");
        timer.sleep(1000);

        System.out.println("\n================사망하지는 않았지만 이게 다잉메시지?!================");
        System.out.println("                    \"" + dyingMessage + "\"");
        System.out.println("=================================================================");
        timer.sleep(1000);
    }

    public void printInvestigationStart() {
        // 7. 용의자 총 인원수 출력
        System.out.println("\n문제의 노트북 주위에 있는 사람은 " + characters.size() + "명입니다.");
        timer.sleep(1000);

        System.out.println("그중, 범인은 바로 이 자리에 있을 것입니다...");
        timer.sleep(1000);
        System.out.println(detectiveName + "님의 임무는 범인을 찾아내는 것입니다. 진실을 밝혀내세요. 기회는 2번입니다.\n");
        timer.sleep(1000);

        System.out.println("########################################");
        System.out.println("#######        추리 시작               ");
        System.out.println("########################################");
        timer.sleep(1000);
    }

    // investigate
    public void investigate() {
        System.out.println("용의자와 대화를 나누고 인상착의를 수집하세요...");
        IntStream.range(0, characters.size()).forEach(i -> System.out.println((i + 1) + ". " + characters.get(i).getName()));  // 용의자 리스트

        System.out.println("\n누구를 조사하시겠습니까? 이름을 입력하세요: ");
        String choiceName = reader.nextLine().trim();

        Optional<Character> foundCharacter = characters.stream()
                .filter(c -> c.getName().equalsIgnoreCase(choiceName))
                .findFirst();

        foundCharacter.ifPresentOrElse(                              // ifPresentOrElse(consumer, runnable) <- 매개변수는 하나. 여러 문장은 {} 사용!
                this::printCharacter,                                // 메서드 참조식, 람다표현식 : chara -> printCharacter(chara)
                () -> handleInvalidInput()
        );
    }

    public void printCharacter(Character chara) {                     // Optional이 자동으로 Character 객체를 넣어줌
        System.out.println(chara.getName() + "의 인상착의를 봅니다.");
        System.out.println("- 머리: " + chara.getHair());
        System.out.println("- 옷: " + chara.getClothes());
        System.out.println("- 신발: " + chara.getShoes());
    }

    public void handleInvalidInput() {
        System.out.println("잘못된 입력입니다! 시간이 얼마 남지 않았습니다, 다시 시도해주세요!");
        System.out.println("범인은 아직도 우리 곁에 있어요. 서둘러 진실을 밝혀내야 합니다!");
        System.out.println(detectiveName + ": 좋아, 이번엔 잘 선택해보자.");
        investigate();
    }

    //matchDyingMessage
    public boolean matchDyingMessage(Character character) {
        return List.of(
                "머리스타일은 " + character.getHair() + " 윽..☠",
                "옷은 " + character.getClothes() + " 윽..☠",
                "신발은 " + character.getShoes() + " 윽..☠"
        ).contains(dyingMessage);
    }

    public String promptChoice(String prompt) {
        while (true) {
            System.out.println(prompt);
            String choice = reader.nextLine();
            if (choice.equals("네") || choice.equals("아니오")) {
                return choice;
            }
            System.out.println("잘못된 입력입니다. 네 또는 아니오만 입력해 주세요.");
        }
    }

    //accuse
    public void accuse() {
        System.out.println("\n범인을 지목할 시간입니다.");

        // 10. charaters 각 항목을 인덱스와 함께 출력
        IntStream.range(0, characters.size()).forEach(i -> System.out.println((i+1)+". "+ characters.get(i).getName()));  //characters.get(i)는 Character 객체 자체를 반환 (객체의 메모리 주소 형식)


        System.out.println("\n누구를 범인으로 지목하시겠습니까? 이름을 입력하세요: ");
        String choiceName = reader.nextLine().trim();
        System.out.println(detectiveName + ": 범인은 바로 " + choiceName + "씨야");

        Optional<Character> foundSuspect = characters.stream()
                        .filter(c-> c.getName().equals(choiceName)).findFirst();

        if (foundSuspect.isPresent()) {
            suspect = foundSuspect.get();
            checkOutcome();
            return;
        }

        System.out.println("탐정님, 그건 잘못된 선택입니다! 시간이 얼마 남지 않았습니다, 다시 시도해주세요!");
        System.out.println("범인은 아직도 우리 곁에 있어요. 서둘러 진실을 밝혀내야 합니다!");
        System.out.println(detectiveName + ": 좋아, 이번엔 잘 선택해보자.\n");
        timer.sleep(1000);
        accuse();
    }

    //checkOutcome
    public void checkOutcome() {
        if (matchDyingMessage(suspect)) {
            System.out.println("""
                    ----------------------------------------------------------------------------------
                    
                    
                         ██████╗  █████╗ ███╗   ███╗███████╗    ██╗    ██╗██╗███╗   ██╗
                        ██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██║    ██║██║████╗  ██║
                        ██║  ███╗███████║██╔████╔██║█████╗      ██║ █╗ ██║██║██╔██╗ ██║
                        ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║███╗██║██║██║╚██╗██║
                        ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚███╔███╔╝██║██║ ╚████║
                         ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝
                    
                    
                    ----------------------------------------------------------------------------------
                    """);
            System.out.println("########################################");
            System.out.println("#######        당신은 역시 명탐정!!         ");
            System.out.println("########################################");
            System.out.println("정답입니다! 범인은 바로 " + suspect.getName() + "씨였습니다!");
            timer.sleep(1000);
            System.out.println("당신의 추리는 완벽했습니다, 역시 명탐정 " + detectiveName + " 답군요.");
            timer.sleep(1000);
            System.out.println("\n" + detectiveName + ": 왜 노트북을 망가뜨렸습니까?? " + victim.getName() + "씨의 노트북을 왜 그렇게 했죠?");
            timer.sleep(1000);
            System.out.println(suspect.getName() + ": 그게 사실... " + victim.getName() + "씨의 팀이 해커톤 우승을 못하게 하려고... 그래서 홧김에.. 죄송합니다🥹");
            timer.sleep(1000);
            System.out.println("\n" + suspect.getName() + "씨는 끝내 자신의 범행을 인정했고, 피로그래밍 22기 해커톤에서 퇴출당했습니다.");
            timer.sleep(1000);
            System.out.println("사건은 해결되었고, 모든 사람들이 안도의 한숨을 내쉬었습니다. 당신의 활약 덕분입니다.");
            timer.sleep(1000);
            askRestart();
            return;         // 성공하면 더 이상 실행할 필요 없으므로 종료
        }

        lives--;

        if(lives==0) {
            System.out.println(
                    """
            ----------------------------------------------------------------------------------

                ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗
                ██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗
                ██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝
                ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗
                ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║
                ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝

            ----------------------------------------------------------------------------------
                    """
            );
            timer.sleep(1000);

            System.out.println("########################################");
            System.out.println("#######         추리 실패......           ");
            System.out.println("########################################");
            timer.sleep(1000);

            System.out.println("\n" + murderer.getName() + ": 명탐정 별거 없네~~~ 해커톤 우승은 내꺼다!!!");
            timer.sleep(1000);

            System.out.println("\n안타깝습니다... 범인은 " + murderer.getName() + "씨였습니다. 모든 기회를 다 써버렸습니다.");
            timer.sleep(1000);
            System.out.println("추리는 실패했습니다. " + detectiveName + " 탐정님, 이번 사건은 당신에게 큰 상처로 남게 될 것입니다.");
            timer.sleep(1000);
            System.out.println("당신은 이 미스터리를 풀 기회를 잃었습니다...");
            timer.sleep(1000);
            System.out.println("하지만, 진정한 탐정은 실패에서도 배웁니다. 다음엔 꼭 진실을 밝혀내세요.");
            timer.sleep(1000);
            askRestart();
            return;
        }

        // 기회가 남았을 때만 실행
        System.out.println(suspect.getName() + ": 무슨 소리야? 내 인상착의를 봐... 당신 명탐정 맞아? 💢💢💢");
        System.out.println("\n틀렸습니다... " + suspect.getName() + "씨는 범인이 아닙니다. 남은 기회는 " + lives + "번입니다.");
        System.out.println("시간이 얼마 남지 않았어요. 신중하게 선택해주세요.");
        timer.sleep(1000);
        String choice = promptChoice("용의자들의 인상착의를 다시 보겠습니까? (네/아니오): ");
        if (choice.equals("네")) {
            System.out.println(detectiveName + ": 좋았어... 다시 차근차근 보자\n");
            timer.sleep(1000);
            mainFlow();
        } else {
            accuse();
        }
    }

    public void askRestart() {
        String choice = promptChoice("게임을 다시 시작하시겠습니까? (네/아니오): ");
        if (choice.equals("네")) {
            resetGame();
            play();
        } else {
            System.out.println("게임을 종료합니다. 감사합니다!");
        }
    }

    public void resetGame() {
        lives = 2;
        victim = null;
        murderer = null;
        suspect = null;
    }

    public void mainFlow() {
        while (true) {
            investigate();
            if (promptChoice("\n계속 조사하시겠습니까? (네/아니오): ").equals("아니오")) {
                break;
            }
        }
        accuse();
    }

    public void play() {
        init();
        showIntro();
        mainFlow();
    }
}
