package oneiros.muj.oneiros.backend;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Siddharth on 30-08-2017.
 */

public class AddData {
    static Clubs newClub;
    static Event newEvent;
    static Contact newContact;
    static String key;
    public static DatabaseReference mDatabase;
    static String description[] = ("aperture is here to provide a platform for the constructive hobby and give the students of the University a platform to showcase their artwork in the form of Photography, Videography, Graphic and Motion Graphic Design on offline and online medium." +
                                    "#Be the Cinematographer, Writer, Actor and Director. Be the Artist in you. Think, write, direct, produce, edit, shoot, stage and perform. Here, at Cinefilia, the Dramatics and Film-making society of Manipal University Jaipur, we aim for an experience and creativity larger than life. Be it the zeal for videos, stage plays or street plays, this is the place where imagination turns into reality." +
                                    "#A family of dancers and platform of talent, Coreografia is the official dance society of the university that keeps the streets and stages of MUJ filled with exuberance.\nWe stand to entertain, enchant and enthrall!" +
                                    "#Litmus is the Literary Club of MUJ, and in that capacity hosts an array of literary events ranging from public speaking and writing to quizzing, through the year. Under Litmus, we have a Debating and a Writing Society where we teach and hone the public speaking and writing skills of our members in every form. Being the only English Literary Club in MUJ, Litmus members constantly participate and win accolades in numerous literary festivals, debates and MUNs throughout the nation." +
                                    "#&quot;Art is not what you see, but what you make others see.&quot;- Edgar Degas\nScribbles, the Art club of Manipal University Jaipur came in to existence 2 years ago. Since then in all the fests conducted especially the cultural fest, we have a major role to play as we form the design team and every tiny bit of theme based recreation is done by us. Also a lot of interesting events are conducted every now and then and during the fest. Our club is dedicated towards all those who wish to unleash their talent or learn something new for which workshops will be conducted in the coming year." +
                                    "#The Hindi club of Manipal University Jaipur aims at enhancing an individuals communicative skills in Hindi and teach them Hindi literature. It will also help you to learn more about Indian culture and society." +
                                    "#&quot;No mind is much employed upon the present recollection and anticipation fill up almost all our moments.&quot; - Samuel Johnson\nSophia - the philosophy club of Manipal University Jaipur, started with just a few people in 2015, is now a huge family of creative thinkers and philosophers.\nWith philosophy, we are able to keep a heuristic point of view.\nIt is all too easy as one ages to mentally ‘wander off’ into a stream of memories, dreams, and reflections unrelated to the moment, yet which insist on dominating consciousness as they flit across the screen of the mind." +
                                    "#The Music Club is the music society of Manipal University Jaipur. The club aims to nurture the talent in every member and provide a conducive environment for mutual learning. We believe that each individual has something to offer and through mentorships, jams, competitions and events we strive to polish skills, share knowledge and spread happiness.").split("#");
    static String clubs[]="aperture#Cinefilia#Coreographia#Litmus#Scribbles#Shabd#Sophia#The Music Club".split("#");
    static String clubUniqueIds[]="-KtNY1ZLdhpVMvj_sFMx#-KtNY1ZTH2f8oV9miI28#-KtNY1ZTH2f8oV9miI29#-KtNY1ZTH2f8oV9miI2A#-KtNY1ZTH2f8oV9miI2B#-KtNY1ZU0kplfYYgVEOf#-KtNY1ZU0kplfYYgVEOg#-KtNY1ZU0kplfYYgVEOh".split("#");
    public static void commit(){
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Clubs");
//        DatabaseReference clubData;
//        for(int i=0;i<clubs.length;i++){
//            clubData=mDatabase.push();
//            newClub= new Clubs(clubs[i],description[i]);
//            try {clubData.setValue(newClub);
//            }catch (Exception e){}
//        }
        //Name,Details,Rules,MinParticipant,MaxParticipant,Fees,FeesMode,JudgingCriteria, Duration
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
        DatabaseReference eventData;
        //Litmus Events
//        newEvent =new Event();
//        newEvent.Time = "N/A";
//        newEvent.Location = "N/A";
//        newContact=new Contact();
//        newEvent.Name="Just A Minute";
//        newEvent.Details="Just a Minute has evolved from a radio show of the same name. In the game, a participant tries to speak on a given topic for one minute, without violating any rules. While he/she is doing so, five other players are waiting to interject, so they can speak.";
//        newEvent.Club=clubUniqueIds[3];
//        newEvent.Duration="N/A";
//        newEvent.Fees=100;
//        newEvent.FeesMode=0;
//        newEvent.Rules="The Jammers are challenged to speak for one minute on a given subject without Interjections. Interjections are classified as:<br>" +
//                "<ul><li> Repetition: Repetition means the repetition of any word or phrase. Challenges based on very common words such as and are generally rejected except in extreme cases of repetition. Words contained on the subject cards can be repeated any number of times.</li>" +
//                "<li> Hesitation: Hesitation is watched very strictly: a momentary pause before continuation of the subject can give rise to a successful challenge, as can tripping over words.</li>" +
//                "<li> Deviation: Deviation means deviating from the subject, but has also been interpreted as &quotdeviating from the English language as we know it&quot and &quotdeviation from grammar as we understand it&uot.</li>" +
//                "<li> Other violations which can be interjected invlude: </li>" +
//                "<ul>" +
//                "<li> Speaking out of turn</li>" +
//                "<li> Early/Late start</li>" +
//                "<li> Anything that judges classify as time wasting tactics</li>" +
//                "</ul>" +
//                "</ul>" +
//                "<Strong>Round 1:</Strong>" +
//                "<ul>"+
//                "<li> A Jammer scores 2 point for making a correct interjection/challenge against whoever is speaking, The player who makes a correct interjection takes over the subject for the remaining minute, or, until he/she is correctly interjected.</li>" +
//                "<li> A player who makes an incorrect interjection loses 1 point.</li>" +
//                "<li> The person speaking at the end of 1 minute is awarded 3 points.</li>" +
//                "<li> The organizing committee has the right to alter the rules, change or cancel the time, venue and the event itself. Decision of the coordinators is the final binding.</li>" +
//                "</ul>"+
//                "<Strong>Round 2</Strong>"+
//                "<ul>" +
//                "<li> Each player will be asked multiple questions in a given time limit, it will be rapid-fire question and answer round.</li>" +
//                "<li> The player should answer the question within 2 seconds without hesitating, stammering and the answer should\n" +
//                "be a complete sentence and not a word or phrase.</li>" +
//                "<li> <Strong>THE TWIST IN THIS ROUND –</Strong>The answer shouldn’t be the correct answer or anything related to the question.</li>" +
//                "<li> Anything that judges classify as time wasting tactics</li>" +
//                "<li> The organizing committee has the right to alter the rules, change or cancel the time, venue and the event itself. Decision of the coordinators is final and binding.</li></ul>";
//        newEvent.MaxParticipant=1;
//        newEvent.MinParticipant=1;
//        newEvent.JudgingCriteria="N/A";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Ankita Doddhilal";
//        newContact.Number="8378835828";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Kartik Jindgar";
//        newContact.Number="9910416488";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//        newEvent.Name="Voice Over";
//        newEvent.Details="In this event participants will be given a video clip, the audio will be muted. The participants will be given preparation time, in which they are supposed to script the scene. After the preparation they will be expected to mimic the script’s lines in coherence to the video that will be running in the background.";
//        newEvent.Club=clubUniqueIds[3];
//        newEvent.Duration="N/A";
//        newEvent.Fees=150;
//        newEvent.FeesMode=1;
//        newEvent.Rules="<ul>" +
//                "<li> A team can have upto two participants.</li>" +
//                "<li> Each team will be given a preperation time of 15 minutes.</li>" +
//                "<li> Participants must bring their own laptop</li>" +
//                "<li> The judgement criteria will be: Creativity, Logic , Entertainment, Coherence of the dialogues with the video, clarity of the plot.</li>" +
//                "<li> The scipt can be either in English or in Hindi.</li>" +
//                "<li> The organizing committee has the right to alter the rules,change or cancel the time, venue and event itself. Decision of the co-ordinators is final and binding.</li>" +
//                "</ul>";
//        newEvent.MaxParticipant=2;
//        newEvent.MinParticipant=1;
//        newEvent.JudgingCriteria="N/A";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Ishita Sinha";
//        newContact.Number="7632008795";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Aditya Chandla";
//        newContact.Number="9466888182";
//        eventData.child("Contact").push().setValue(newContact);
//
//        newEvent.Name="Super Wordsmith";
//        newEvent.Details= "A one of its kind essay writing event which will bring out the super hero nostalgia in you.";
//        newEvent.Club=clubUniqueIds[3];
//        newEvent.Duration="N/A";
//        newEvent.Fees=100;
//        newEvent.FeesMode=0;
//        newEvent.Rules= "<ul>" +
//                        "<li> Each participant will have to pick up 3 chits kept in three different boxes.</li>" +
//                        "<li> Contents of the box:" +
//                        "<ul>" +
//                        "<li> Box 1: Names of superheroes</li>" +
//                        "<li> Box 2: Names of villains</li>" +
//                        "<li> Box 3: Names of superheroes and villains combined</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<li> Plot a story around the characters.</li>" +
//                        "<li> Minimum number of words 250.</li>" +
//                        "<li> Time allotted is 45 minutes.</li>" +
//                        "</ul>";
//        newEvent.MaxParticipant=1;
//        newEvent.MinParticipant=1;
//        newEvent.JudgingCriteria="N/A";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Ayush Jamjute";
//        newContact.Number="9769357550";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Nishi Taneja";
//        newContact.Number="9660229032";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//        newEvent.Name="Quiznos";
//        newEvent.Details="Quiznos is the most competitive, compelling and well researched quiz Manipal University Jaipur has<br>" +
//                "ever offered. With an enthralling set of four innovative rounds, you are guaranteed a joyride<br>" +
//                "throughout the event, both as a spectator and especially as a participant. Pop Culture, Politics,<br>" +
//                "Recent History, Fashion, Sports, Science and Technology, this quiz encompasses a knowledge forte<br>" +
//                "of each and every one of the participants to ensure a higher level of excitement and interaction.";
//        newEvent.Club=clubUniqueIds[3];
//        newEvent.Duration="N/A";
//        newEvent.Fees=150;
//        newEvent.FeesMode=1;
//        newEvent.Rules= "<ul>" +
//                        "<li> Round 1 (Prelims)" +
//                        "<ul>" +
//                        "<li> Questions would be projected on the screen, or A/V questions would be played</li>" +
//                        "<li> Teams would have to write their answers on a sheet of paper</li>" +
//                        "<li> All the questions would not carry the same number of marks, marking scheme would be disclosed</li>" +
//                        "<li> In case of a tie, a tie breaker round will take place</li>" +
//                        "<li> The rules of the tie breaker round would be disclosed at the event itself</li>" +
//                        "<li> The decision of the quizmaster is final and binding</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<br><li>Bounce and Pounce (8 teams)" +
//                        "<ul>" +
//                        "<li> Each direct question carries 30 points.</li>" +
//                        "<li> There is no negative marking on direct and passed questions.</li>" +
//                        "<li> 30 seconds to answer</li>" +
//                        "<li> Indefinite Passing allowed.</li>" +
//                        "<li> Passed questions carry 10 points.</li>" +
//                        "<li> Pounce is open for the first 15 seconds</li>" +
//                        "<li> You can pounce by raising your hand and writing your answer down when the quizmaster announces pounce</li>" +
//                        "<li> A correct pounce is worth 40 points and a wrong one will result in -20</li>" +
//                        "<li> The decision of the quizmaster is final and binding</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<br><li> Bet It All (6 Teams)" +
//                        "<ul>" +
//                        "<li> The team would have to choose a category of questions</li>" +
//                        "<li> The team would have to bet from their existing pool of points before the question is announced</li>" +
//                        "<li> For correct answer, number of points scored by the team would be the double of what they bet</li>" +
//                        "<li> For wrong answer, the team would lose the number of points they bet</li>" +
//                        "<li> For no answer, the team would not lose any points</li>" +
//                        "<li> One minute to answer</li>" +
//                        "<li> Pounce is not open for this round</li>" +
//                        "<li> The decision of the quizmaster is final and binding</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<br><li> The Finale (4 Teams)" +
//                        "<ul>" +
//                        "<li> A total of 12 questions will be asked</li>" +
//                        "<li> Each question would have partial marking and could not be passed on</li>" +
//                        "<li> No negative marking on wrong answers</li>" +
//                        "<li> Followed by a surprise round</li>" +
//                        "<li> The decision of the quizmaster is final and binding</li>" +
//                        "</ul>" +
//                        "</li>";
//        newEvent.MaxParticipant=2;
//        newEvent.MinParticipant=2;
//        newEvent.JudgingCriteria="N/A";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Krishna Chaturvedi";
//        newContact.Number="7297997935";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Avinash Lamba";
//        newContact.Number="9660396983";
//        eventData.child("Contact").push().setValue(newContact);
//
//        newEvent.Name="Spell Bee";
//        newEvent.Details="&quot;Words cast spells, and that’s why it’s called SPELLING&quot; Litmus invites you to participate in the Spell Bee competition in Oneiros, 2017. It will be a brilliant platform to test your spelling skills in three very easy and enthralling rounds.";
//        newEvent.Club=clubUniqueIds[3];
//        newEvent.Duration="N/A";
//        newEvent.Fees=100;
//        newEvent.FeesMode=0;
//        newEvent.Rules= "<ul>" +
//                        "<li> The event will consist of three separate rounds with the first round being an elimination round. A crossword of 5 marks + MCQ type questions of 15 marks will be given to each participant and the participant will have to submit their sheets in a given time limit. About 60% of the participants of the total number will qualify for the next round, on the basis of their scores.</li>" +
//                        "<li> The second round will also be an elimination round where each participant will have to spell out the maximum number of words, called out to them in 60 seconds. Each correct spelling will give the participant 5 points. 7-8 participants will qualify to the next round where they will have to spell out 5 words, called out to them without any time limit. At the end of this round the winner and runner up will be selected on the basis of the scores.</li>" +
//                        "<li> In case there is a need of a tie-breaker, one spelling will be given to the participants after the particular round, and whoever answers first and correctly, will qualify. The participants can ask for the meaning or origin of the word.</li>" +
//                        "<li> The OC’s have the right to alter the rules, change or cancel the time, venue and the event itself. The decision of the coordinators is final and binding.</li>" +
//                        "</ul>";
//        newEvent.MaxParticipant=1;
//        newEvent.MinParticipant=1;
//        newEvent.JudgingCriteria="N/A";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Kavleen Sabharwal";
//        newContact.Number="8582807713";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Atmadip Mukherjee";
//        newContact.Number="9660299067";
//        eventData.child("Contact").push().setValue(newContact);
//
//        newEvent.Name="Pictionary";
//        newEvent.Details="A word guessing game where the teammates have to guess the word (animal/object/place/movie) their teammate is trying to convey by channelling their inner Picasso.";
//        newEvent.Club=clubUniqueIds[3];
//        newEvent.Duration="N/A";
//        newEvent.Fees=150;
//        newEvent.FeesMode=1;
//        newEvent.Rules="<ul>" +
//                        "<li> Each team member will have to take turns going up to the board.</li>" +
//                        "<li> Time limit will vary in each round.</li>" +
//                        "<li> Three rounds:" +
//                        "<ul>" +
//                        "<li> Traditional Pictionary round.</li>" +
//                        "<li> Taboo round.</li>" +
//                        "<li> Multiple guess round.</li>" +
//                        "<li> Backup round in case there&#39;s a tie. (Multiple guess round)</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<li> Each round will be an elimination round.</li>" +
//                        "<li> Filtering of teams will be decided based on the number of participants.</li>" +
//                        "<li> Verbal communication is not permitted.</li>" +
//                        "<li> Writing letters or words in any language will lead to disqualification.</li>" +
//                        "<li> Expected duration of the event: 2 hours, 30 minutes.</li>" +
//                        "<br><li>Round 1 (Traditional Pictionary)" +
//                        "<ul>" +
//                        "<li> Time limit : 60 seconds per team.</li>" +
//                        "<li> One chit per team.</li>" +
//                        "<li> Time taken can be considered as an elimination criteria.</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<br><li>Round 2 (Taboo Round)" +
//                        "<ul>" +
//                        "<li> Time limit : 90 seconds per team.</li>" +
//                        "<li> Chit format: Word: Pokémon ; Taboo words: Pikachu, Poké ball.</li>" +
//                        "<li> The team member drawing on the board cannot draw any of the taboo words. He/she will need to use other creative ideas for the teammates to guess the answer.</li>" +
//                        "<li> One chit per team.</li>" +
//                        "<li> Time taken can be considered as an elimination criteria.</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<br><li>Round 3 (Multiple guess round)" +
//                        "<ul>" +
//                        "<li> Time limit : 120 seconds per team.</li>" +
//                        "<li> The team can draw a chit after each correct guess.</li>" +
//                        "<li> The team with the maximum number of correct guesses will be in the lead.</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "</ul>" +
//                        "<br>OC has the right to alter the rules, change or cancel the time, Venue and the event itself. Decision of the coordinators is final and binding." +
//                        "<br><br>Club is not responsible for participant activity within the event.";
//        newEvent.MaxParticipant=3;
//        newEvent.MinParticipant=2;
//        newEvent.JudgingCriteria="N/A";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Aripra Pandey";
//        newContact.Number="9660228670";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Karthik Agarwal";
//        newContact.Number="9948180953";
//        eventData.child("Contact").push().setValue(newContact);
//
////  //Cinefelia Events
//
//        newEvent.Name = "Awaaz";
//        newEvent.Details = "हुंकार हो या दहाड़<br>सब को यह बतलायेंगे <br>डंके की चोट पे <br>आवाज़ हम उठाएंगे<br>अक्सर हम अपने मन की आवाज़ दबा देते है यह सोच कर की दुनिया क्या बोलेगी | हम अपनी आवाज़ नहीं उठाते , सही को सही और गलत को गलत बताने के लीये | इस दुनिया में कितनी गलत चीज होती है जीन्हें सीरफ | एक मंच चाहिए होता है दर्शा ने के लीऐ | तोह हम CINEFILIA - The Dramatics And Film Making Society of MUJ , आपको यह अवसर देते है की आप हमरे नुक्कड़ नाटक प्र्त्योगिता में भाग ले और वोले की कुछ &quot; कुछ गलत है &quot;!!!";
//        newEvent.Rules ="<ul>" +
//                        "<li> Time limit will be 20 minutes. Anyone exceeding it will be awarded negative points.</li>" +
//                        "<li> The team should consists of 9-20 members</li>" +
//                        "<li> The combination of kurta and chunni should be pre informed.</li>" +
//                        "<li> The play shall exhibit a social message.</li>" +
//                        "<li> No electronic and prerecorded sounds are allowed</li>" +
//                        "<li> Use of props is allowed. Organizing team will not provide any props. The teams should come with their own props, if there are any</li>" +
//                        "<li> Languages used shall be English or Hindi or both</li>" +
//                        "<li> Explicit, abusive or vulgar content will not be allowed</li>" +
//                        "<li> Only the teams clearing the prelims will be allowed to perform</li>" +
//                        "<li> The judge’s decision will be final and binding</li>" +
//                        "<li> One can register their team online</li>" +
//                        "<li> Registration fees is Rs. 100/person which has to be paid on spot when teams arrive</li>" +
//                        "<li> Registration to be done at least 2 hours prior to prelims</li>" +
//                        "</ul>";
//        newEvent.MinParticipant = 9;
//        newEvent.MaxParticipant = 20;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria =  "<ul>" +
//                                    "<li> Coordination</li>" +
//                                    "<li> Script</li>" +
//                                    "<li> Clarity of script</li>" +
//                                    "<li> Formations</li>" +
//                                    "<li> Audience interaction</li>" +
//                                    "<li> Area usage</li>" +
//                                    "<li> Timing</li>" +
//                                    "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact = new Contact();
//        newContact.Name = "Shruti Dhar";
//        newContact.Number = "9660394908";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Nimer Amol Singh";
//        newContact.Number = "9999206661";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Tushti B.R";
//        newContact.Number = "9660418708";
//        eventData.child("Contact").push().setValue(newContact);
//
//        newEvent.Name = "Pandora's-Box";
//        newEvent.Details = "Pick up a camera. Shoot something. <br>No matter how small,<br>No matter how cheesy,<br>No matter whether your friends <br>And your sister star in it.<br>Put your name on it<br>As director.Now you are a director.<br>Everything after that <br>" +
//                "you are just negotiating your budget and your fee.<br>" +
//                "                                    -James Cameron<br><br>" +
//                "Do you call yourself a passionate lover of classy cinema, do you want to be the initiator of change in the society or do you want to take this world on an adventure? You are free to do any of the above with the help of your lens; you are free to show us what do you want us to see but you have only 25 minutes. Just make a short film or a documentary, upload it on youtube and send it's link to us before 6th October 2017 11:59:59 pm.";
//        newEvent.Rules ="<ul>" +
//                "<li> Time limit: 2 minutes-25 minutes.</li>" +
//                "<li> Negetive marks will be awarded for exceeding the time limit.</li>" +
//                "<li> Participants are supposed to upload the film on their youtube channel and the link has to be submitted on our online form.</li>" +
//                "<li> The film can be in any language.</li>" +
//                "<li> English subtitles should be provided</li>" +
//                "<li> There is no restriction on the theme</li>" +
//                "<li> The link should be sent before 6th October 2017 11:59:59 PM.</li>" +
//                "<li> Multiple entries are allowed.</li>" +
//                "<li> Plagiarism is strictly prohibited</li>" +
//                "<li> The content of the movie should be appropriate for public screening and thus have no vulgarity.</li>" +
//                "<li> Entries must be the original work of the entrant and must not infringe third-party's rights.</li>" +
//                "<li> The organizing committee can, at any stage mend the rules and/or disqualify your entry.</li>" +
//                "<li> Watermarks are strictly not allowed on any of the films. Entries with watermarked films will be immediately disqualified.</li>" +
//                "<li> The team details are to be submitted in the following format-1. College name, 2. Team member details.</li>" +
//                "<li> The official mail id for this event would be cinefiliamuj@gmail.com</li>" +
//                "<li> Participants are required to send the link on cinefiliamuj@gmail.com as well.</li>" +
//                "<li> Keep checking the fest website for further information. www.oneiros.co.in</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 9;
//        newEvent.MaxParticipant = 20;
//        newEvent.Fees = 300;
//        newEvent.FeesMode = 1;
//        newEvent.JudgingCriteria =  "<ul>" +
//                "<li> Creativity</li>" +
//                "<li> Direction</li>" +
//                "<li> Scripting(Originality)</li>" +
//                "<li> Cinematography</li>" +
//                "<li> Execution</li>"+
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact = new Contact(); newContact.Name = "Mahrishi Bisani";
//        newContact.Number = "9840741386";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Ambuj Agrawal";
//        newContact.Number = "8586915820";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//
//        newEvent.Name = "Qissa-e-Dastan";
//        newEvent.Details = "&quotThere are too many idea and things and people, too many directions to go. I was starting to believe the reason it matters care passionately about something is that it whittles the world down to more manageable size.&quot-Charlie Kaufman (From Adaption)<br>" +
//                "We all have some stories to share, we all wanted to be storytellers at some point of time in our lives. Why not pen it down and mark it up with others, why not subject your emotions to the expression. We bring you a stage where we all storytellers unite to mark our thoughts and emotions to subject the art of storytelling.";
//        newEvent.Rules ="<ul>" +
//                "<li> The event is strictly online, hence last day of submission of your script is the second day of the Fest, i.e. _______’2017</li>" +
//                "<li> The script should be original and creative, Plagiarism is not tolerated under any circumstances.</li>" +
//                "<li> The script preferably should be based on the theme of the fest, reminiscence.</li>" +
//                "<li> You can start submitting your scripts by 1st Oct. 2017</li>" +
//                "<li> There is complete creative liberty, it’s the storytelling which counts.</li>" +
//                "<li> The language subjected for content can be either English or Hindi. </li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event</li>" +
//                "<li> Decisions of the jury are final and no requests for reconsideration will be entertained.</li>" +
//                "<li> All participants are supposed to mail their entries to the email id provided below.</li>" +
//                "<li> Email ID - shabdcluboc@googlegroups.com</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 1;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 1;
//        newEvent.JudgingCriteria =  "<ul>" +
//                "<li> Creativity</li>" +
//                "<li> Content</li>" +
//                "<li> Plot,character development etc.</li>" +
//                "<li> Storytelling capabilities</li>" +
//                "<li> Realism</li>"+
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact = new Contact(); newContact.Name = "Pratyushraj Singh Sisodia(Cinefilia)";
//        newContact.Number = "9479857756";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Arjun Gupta(Shabd)";
//        newContact.Number = "8199999453";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//
//
//        // Rangmanch //
//
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "Rangmanch";
//        newEvent.Details = "All the world’s a stage,<br>And all the men and women merely players.<br>The stage is set. The lights fade in, curtains are up, the actors get into their characters, and here starts the show. Amidst the drum rolls, swaying swords, moving words, blazing lights, you have to capture the audience with your gestures so subtle and emotions so strong, definitely as lovely as it sounds. If you are ready to portray someone you're not with all the zeal you have, then this is your chance!<br>Participation will be through online entry and fees will be paid at on-spot registration desk.  Lighting will be provided but any specific schemes has to brought by the teams. There will be a preliminary round in which the screening will be done and the final performing 5 teams will be selected. The teams will perform their play in front of audience and judges. The play can be in English or Hindi or both.";
//        newEvent.Rules = "<strong>Prelims</strong>"+
//                "<ul>" +
//                "<li> Each team will have to go through a 10 minutes preliminary round in which they have to perform the best part of their skit which gives a brief idea about the play.</li>" +
//                "<li> Team should consist 4-25 members.</li>" +
//                "<li> Teams need to submit a copy of their script beforehand, at least 3-4 hours before the competition.</li>" +
//                "</ul>" +
//                "<br><strong>Finals</strong>" +
//                "<ul>" +
//                "<li> Round Duration: 30-50mins</li>" +
//                "<li> Team should consist 4-25 members.</li>" +
//                "<li> There'll be negative marking if a team exceeds given time limit.</li>" +
//                "<li> Medium: Hindi or English or both.</li> " +
//                "<li> All clothes accessories and props of the play are to be arranged by the participating team.</li>" +
//                "<li> The organizing committee is responsible only for the infrastructural facilities (Green Room).</li>" +
//                "<li> Obscenity (at the discretion of the judges) of any kind is not allowed and will lead to immediate disqualification.</li>" +
//                "<li> The decision of the judges will be final and binding.</li>" +
//                "<li> Participants must bring the background music of the skit in standard secondary storage device.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 4;
//        newEvent.MaxParticipant = 25;
//        newEvent.Fees = 150;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Originality</li>" +
//                "<li> Stage set up and use of space</li>" +
//                "<li> Flow of content</li>" +
//                "<li> Voice Clarity</li>" +
//                "<li> Acting skills</li>" +
//                "<li> Clarity of the idea delivered</li>" +
//                "<li> Impact of the play</li>" +
//                "<li> Audience Reaction</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//        eventData.setValue(newEvent);
//        newContact.Name = "Aditya Aggarwal";
//        newContact.Number = "9910355173";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Peeyush Yadav";
//        newContact.Number = "9660221638";
//
//// MONO ACT
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "MONO ACT";
//        newEvent.Details = "MONO ACT is a super fun event designed to test the mettle of limelight huggers. One can enact different characters using different tones, styles, dialogue delivery, expression, voice boundaries and much more. Portrayal of each character should be distinct. Costume change according to characters is not necessary. The one stop destination and platform that all actors have been waiting for is finally here!";
//        newEvent.Rules = "<ul>" +
//                "<li> You have to come prepared with your own theme.</li>" +
//                "<li> Only solo performances are allowed</li>" +
//                "<li> Timer will start as soon as the participant gets on stage.</li>" +
//                "<li> Participant have to perform for minimum of 3 minutes and maximum of 7 minutes.</li>" +
//                "<li> Obscenity and offensive gestures are strictly not allowed.</li>" +
//                "<li> A warning bell will be rung past 4 minutes, 5 minutes and 7 minutes. Participants will not be allowed to perform after the 3rd warning bell.</li>" +
//                "<li> Pre Recorded music (if any) have to be submitted at least 2 hours before the performance.</li>" +
//                "<li> Decision of judges will be final and binding.<br>Violation to any rule may result in disqualification.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 25;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Voice Modulation</li>" +
//                "<li> Variety of characters</li>" +
//                "<li> Flow of expressions</li>" +
//                "<li> Acting skills</li>" +
//                "<li> Audience Impact</li>" +
//                "<li> Stage Utilization</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//        eventData.setValue(newEvent);
//        newContact.Name = "Mohit Singh (call)";
//        newContact.Number = "9660170986";
//        newContact.Name = "Mohit Singh (whatsapp)";
//        newContact.Number = "9568028177";
//        eventData.child("Contact").push().setValue(newContact);
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Apoorva Tiwari (call)";
//        newContact.Number = "8696232271";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Apoorva Tiwari (whatsapp)";
//        newContact.Number = "9936549008";
//        eventData.child("Contact").push().setValue(newContact);
//
//
// //    // One Mic Stand
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "One Mic Stand";
//        newEvent.Details = "Are you the person who brings the life to a group? Do you think you have the wits to tickle the funny bone? Then here is your opportunity to showcase your hilarious talent! Show us your funny bone. It doesn't matter if you do deadpan, intelligent, satirical or slapstick comedy. If you can make people laugh, this is the place for you.<br>So, come on. Put on your lucky shoes and take the stage. Let the comedian in you out for everybody to appreciate, and more importantly, humor us!";
//        newEvent.Rules = "<strong>Prelims</strong>" +
//                "<ul>" +
//                "<li> Round Duration: Each of the participants will get 3-4 minutes of stage time.</li>"+
//                "<li> Usage of any kind of prop is not allowed during the performance.</li>" +
//                "<li> Performer may interact with the audience to make his/her performance interesting.</li>" +
//                "<li> No cuss words are allowed.</li>" +
//                "<li> Explicit content should be avoided.</li>" +
//                "<li> The participant can choose to perform in either English or Hindi only.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event.</li>" +
//                "<li> Contents of prelims and finals does NOT have to be different, however it is prefered that participants perform different sets. No marks will be taken away for performing the same set.</li>" +
//                "<li> Decisions of the jury are final and no requests for reconsideration will be entertained.</li><br>FINALS" +
//                "<li> Each participant will get 4-5 minutes of stage time.<br>Usage of any kind of prop is not allowed during the performance.</li>" +
//                "<li> Performer may interact with the audience to make his/her performance interesting. </li>" +
//                "<li> No cuss words are allowed.</li>" +
//                "<li> Only orignal content is allowed. If content is plagiarized, participants will be immediately disqualified.</li>" +
//                "<li> Explicit content should be avoided.</li>" +
//                "<li> The participant can choose to perform in either English or Hindi only.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event.</li>" +
//                "<li> Decisions of the jury are final and no requests for reconsideration will be entertained.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 2;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Negative marks will be awarded if the participant exceeds the time limit.</li>" +
//                "<li> The participant will be judged on the basis of originality, creativity, humour, audience interaction and reactions.</li>" +
//                "<li> Marks will deducted on the use of abusive language.</li>" +
//                "<li> Direct profanity might be judged negatively depending on the judges. Subtlety is the way to go.</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name = "Akash Johnson";
//        newContact.Number = "9716698330";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Soumya Goel";
//        newContact.Number = "9660272403";
//        eventData.child("Contact").push().setValue(newContact);
////
////
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "UNO..DOS...ACT!!!";
//        newEvent.Details = "Think you're the king of spontaneity? Ever been on stage without a script? If yes then come showcase your improv skills in Cinefilia's event UNO DOS ACT.<br>Participants will be given an impromptu scene or a situation and they're expected to enact it at that very moment. Each team would get exactly 5 minutes to make or break their act. We aren’t looking for a well prepared act, we are looking for that team who can understand each other so well that they pick up each other’s cues on stage and develop right there on the stage.<br>This form of theatre is called IMPROV.";
//        newEvent.Rules = "<ul>" +
//                "<li> Each team can comprise of 5-6 members.</li><li> Topic fo the improv will be given on the spot.</li>" +
//                "<li> Preparation time (for discussion nd setup) should not exceed 5 minutes.</li>" +
//                "<li> Run time for the act should not exceed 3 minutes.</li>" +
//                "<li> Marks will be deducted if any of the time limit is exceeded.</li>" +
//                "<li> Each member o the team should be a part of the act.nOnly the props provided, can be used.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 5;
//        newEvent.MaxParticipant = 6;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Creativity</li>" +
//                "<li> Flow of content</li>" +
//                "<li> Character definition<br>Voice clarity</li>" +
//                "<li> Acting skills<br>Audience feedback</li>" +
//                "<li> Teamwork and understanding</li>" +
//                "<li> (The final decision regarding any of the rules or judging criteria, lies with the judges of the event. If need be, the participants will be notified accordingly, well in time).</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//        eventData.setValue(newEvent);
//        newContact.Name = "Aayoush Dubey";
//        newContact.Number = "8879115959";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Saurav";
//        newContact.Number = "9555958955";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//
//// Ad-Mak
//
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "Ad-Mak";
//        newEvent.Details = "&quot;Hey, have you seen the new shampoo ad?&quot;" +
//                "<br>&quot;Oh that one? Yeah I did, but didn't really like it much.&quot;" +
//                "<br>We're sure you've had a similar conversation." +
//                "<br>But do you have the guts to actually make an advertisement?" +
//                "<br>Here's a challenge for you." +
//                "<br>Presenting AD-MAK, an event to fire your creativity.";
//        newEvent.Rules = "<ul>" +
//                "<li> Each team comprises of 3-6 participants.</li>" +
//                "<li> 20 minutes will be allocated to all groups for preparing their advertisement." +
//                    "The length of the advertisement must be less than 5 minutes. Participants will be penalized " +
//                    "for exceeding the time limit.</li>" +
//                "<li> The advertisement can be performed in Hindi, English or a combination of the two.</li>" +
//                "<li> Points will be deducted for plagiarism.</li>" +
//                "<li> Each team will be given one item that will be the central product used in their advertisement. " +
//                    "The items will be allotted via chits.</li>" +
//                "<li> A few other props will be provided for use in the advertisement. Extra points will be rewarded for their appropriate usage</li>" +
//                "<li> Each team must come up with a catchphrase/jingle that relates to their item and it must be incorporated in the advertisement.</li>" +
//                "<li> Obscenity is not allowed and will lead to immediate disqualification.</li>" +
//                "<li> The decision of the judges is final.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event.</li></ul>";
//        newEvent.MinParticipant = 3;
//        newEvent.MaxParticipant = 6;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Spontaneity</li>" +
//                "<li> Content</li>" +
//                "<li> Adherence to the topic</li>" +
//                "<li> On-stage presentation</li>" +
//                "<li> Creativity</li>" +
//                "<li> Coordination</li>" +
//                "<li> Overall appeal</li>" +
//                "<li> Do not exceed the time limit.</li>" +
//                "<li> Negative marks will be provided for the things mentioned above.</li>" +
//                "<li> Decision of the judges will be final and binding</li>" +
//                "<li> Caution should be taken to refrain from displaying obscenity, violence, prejudice, defamation, plagiarism etc.</li></ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[1];
//        eventData.setValue(newEvent);
//        newContact.Name = "Aakarasha S.";
//        newContact.Number = "9971321024";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Abhishek Arora";
//        newContact.Number = "8527983347";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//        //Scribbles
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Club = clubUniqueIds[4];
//        newEvent.Name = "Style the Stamp";
//        newEvent.Details = "It is an event based on the theme of reminiscence." +
//                "<br>Have you seen the post stamps in your childhood? It’s the same thing you have to design but in a funky way. But you have to use minimum colours and how they can be used to recreate the historical things into modern art." +
//                "<br>You can use two ways-Present the modern things in retro way or historical things in modern way.";
//        newEvent.Rules = "<ul>" +
//                "<li> It is a painting event and a single participation event.</li>" +
//                "<li> The painting should be entirely within the theme provided.</li>" +
//                "<li> No external help is permitted.</li>" +
//                "<li> The materials will be provided at the beginning of the event that will be equal for all.</li>" +
//                "<li> No extra time will be provided.</li>" +
//                "<li> Maximum 3 colours are allowed for making the stamp.</li>" +
//                "<li> Anyone found using unfair means or in violation of any of the above-mentioned rules and regulations will be disqualified immediately.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event.</li>" +
//                "</ul>";
//        newEvent.JudgingCriteria ="N/A";
//        newEvent.Duration = "1 hr 15 min";
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 0;
//        newEvent.MinParticipant=1;
//        newEvent.MaxParticipant=2;
//        eventData.setValue(newEvent);
//        newContact.Name = "Shefali Kulshrestha";
//        newContact.Number = "9660210545";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Mehul Jhaver";
//        newContact.Number = "9100940979";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Club = clubUniqueIds[4];
//        newEvent.Name = "Paint O Neck";
//        newEvent.Details = "Team event based on the theme of the fest that is reminiscence. Opportunity for artists to show their creativity through cartooning on t-shirts. All you need to do is present the favourite character from our childhood saying well-known lines from today’s generation. Be funky, show your originality.";
//        newEvent.Rules = "<ul>" +
//                "<li> White T-Shirt will be provided to all participants before the event.</li>" +
//                "<li> T-shirts will be returned to participants along certificates.</li>" +
//                "<li> Any untidy work will be disqualified.</li>" +
//                "<li> Participants will paint according to any of the given theme.</li>" +
//                "<li> Participants will use only FABRIC COLOURS or ACRALYC COLOURS to paint on White T-Shirts.</li>" +
//                "<li> All participants will be provided fabric colours (specific colours), brush & all material required for painting.</li>" +
//                "<li> Single participant is allowed. Otherwise only two participants are allowed.</li>" +
//                "<li> Participants will be evaluated for originality, creativity and overall presentation.</li>" +
//                "<li> Participants can also bring colours according to their own preference.</li>" +
//                "<li> Participants will be given 1 hr 30 min. to show their creativity and 2 minutes to talk about the same.</li>" +
//                "</ul>";
//        newEvent.JudgingCriteria = "N/A";
//        newEvent.Fees = 200;
//        newEvent.MinParticipant = 2;
//        newEvent.MaxParticipant = 2;
//        newEvent.FeesMode = 1;
//        newEvent.Duration="1 hr 30 min + 2 min";
//        eventData.setValue(newEvent);
//        newContact.Name = "Harshit Narang";
//        newContact.Number = "7065597123";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Tanmay Patidar";
//        newContact.Number = "9713611178";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Club = clubUniqueIds[4];
//        newEvent.Name = "Junk-O-Mania";
//        newEvent.Details = "Junk-O-Mania is the use of how judicially and effectively trash can be used to make something creative and attractive. The use of just 8-10 things that we feel are no longer usable, can help us make some beautiful modern art. Topics will be given on the spot to maintain originality.";
//        newEvent.Rules = "<ul>" +
//                " <li> Team shall consist of two members only.</li>" +
//                " <li> No items that can be reused is allowed.</li>" +
//                " <li> The required waste material and stationery like scissor, thread, etc. will be provided but participant can bring their own materials also"+
//                " <li> In case you require materials other than the materials mentioned above, you are requested to bring it along with you.</li>" +
//                " <li> Waste material could be anything like tetra packs, bottles, newspapers, old utensils, jute material or any second hand items that otherwise would be thrown away.</li>" +
//                " <li> The material would be rejected if not found to be a waste product or second hand item</li>" +
//                " <li> No ready or semi-finished model or matter would be accepted from participant in competition.</li>" +
//                " <li> Participants will be judged on Creativity, Utilization of Resources, Artistic composition & design and Overall Presentation.</li>" +
//                " <li> No mobile or Internet means would be allowed to use at the time of Competition.</li>" +
//                " <li> The decision of the judges will be considered final and abiding.</li>" +
//                " <li> Participants will be given 1 hr 45 min. to show their creativity and 2 minutes to talk about the same.</li>" +
//                "</ul>";
//        newEvent.Fees = 200;
//        newEvent.Duration="1 hr 45 min + 2 min";
//        newEvent.FeesMode = 1;
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 2;
//        newEvent.JudgingCriteria = "N/A";
//        eventData.setValue(newEvent);
//        newContact.Name = "Parth Sarthi Rawat";
//        newContact.Number = "9993706719";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Shruti Varma";
//        newContact.Number = "9660314791";
//        eventData.child("Contact").push().setValue(newContact);
//
////        aperture
//        newEvent = new Event(
//                "Flare",
//                "Flare will test the promptness as well as the creativity of photographers. Not only the picture, the idea but also the thought process behind it is required to win this event. Participants will be given 5 hour's time and a theme which will be disclosed on the spot.",
//                "<ul>" +
//                        "<li> Participants have 5 hours in which they can click and edit photos.</li>" +
//                        "<li> No filters are allowed for the photographs. Pictures will be allowed straight out of Camera</li>" +
//                        "<li> Only colored and/or B&W photos are to be submitted.</li> " +
//                        "<li> Participants cannot put any kind of water mark on their photos.</li>" +
//                        "<li> If any of the above rule is violated aperture team will remove the photo from consideration.</li>" +
//                        "<li> All photos must be submitted in person. No proxy submission will be entertained.</li> " +
//                        "<li> All the photos must be submitted on or before the given deadline.</li> " +
//                        "<li> The organizers have the right to refuse the entry which will be submitted late.</li>" +
//                        "<li> By agreeing to participate the participant agrees that in case of any dispute arising with regard to the photo credits or objection raised by subject captured in the photographs post submission, APERTURE will not hold responsibility for the same.</li>" +
//                        "<li> Change of rules and/or time and acceptability of entries are at the discretion of the Organizing Committee members.</li>" +
//                        "</ul>",
//                1,2,100,0,"N/A","4 Hours",clubUniqueIds[0],"N/A","N/A");
//                eventData=mDatabase.push();
//                eventData.setValue(newEvent);
//                newContact.Name = "Abhishek";
//                newContact.Number = "8800350581";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Purva Sharma";
//                newContact.Number = "7073810098";
//                eventData.child("Contact").push().setValue(newContact);
//
//        newEvent = new Event("Showdown of Societies",
//                "You have a story that you want to narrate through your pictures? A photograph has the ability to convey emotions, moods, narratives, ideas and messages – all of which are important elements of telling a story.<br>It will be an online photography competition where members from each team will try and narrate a story through their pictures.",
//                "<ul>" +
//                        "<li> This competition is open to all photography clubs from any college or university.</li>" +
//                        "<li> The team should have a minimum of 2 members and a maximum of 5 members.</li>" +
//                        "<li> There is no restriction on number of teams per club/college.</li>" +
//                        " <li> A photo story can have a maximum of <strong>SEVEN</strong> photographs and a minimum of TWO photographs.</li>" +
//                        "<li> Watermarks are strictly not allowed on any of the photographs. Entries with watermarked photographs will be immediately disqualified.</li>" +
//                        "<li> Only basic enhancements such as sharpening, contrast adjustments, brightness are allowed. Multiple layering and HDR are not permitted.</li>" +
//                        "<li> All photos must be submitted in person. No proxy submissions will be entertained.</li>" +
//                        "<li> All entries must be submitted on or before the given deadline. The winners will be declared for 1stand 2nd position only.</li> " +
//                        "<li> By agreeing to participate, the participant agrees that in the case of any dispute, with regard to the ownership or any objection raised by subjects captured in the participant’s photo post submission, APERTURE PHOTOGRAPHY SOCIETY, will not be liable for responsibility of the same.</li> " +
//                        "<li> The organizers reserve the right to decline entry to participant in case the deadline or the above mentioned rule(s) is violated.</li> " +
//                        "<li> Change of rules and/or time and acceptability of entries are at the discretion of the Organizing Committee members.</li>" +
//                        "</ul>",
//                2,5,100,0,"N/A","N/A",clubUniqueIds[0],"N/A","N/A");
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name = "Sandeep Talukdar";
//        newContact.Number = "9871576889";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Rohan Sood";
//        newContact.Number = "9004388996";
//        eventData.child("Contact").push().setValue(newContact);
//
//        newEvent = new Event("InstAperture",
//                "The Mobile Photography Competition <br>Categories:Phone only.<br>3 positions (each for a theme)<br>Prizes worth 3000/-","" +
//                "<ul>" +
//                "<li> To make your entry valid the participant must be following aperturemuj, the official Instagram handle of the aperture</li>" +
//                "<li> Your Instagram account should be public.</li>" +
//                "<li> Registration procedure: Please register online at www.oneiros.co.in or at the registration desk,then upload the photo on Instagram with the hashtag #instaperturemuj or #relivemuj , your registration ID and the theme in which you’d like the photo to be judged.</li>" +
//                "<li> Usage of inbuilt Instagram filters is allowed</li>" +
//                "<li> The participant can take part only in two themes.</li>" +
//                "<li> Each participant can upload 3 photos in each of the two or one theme he/she is a part of.</li>" +
//                "<li> Use of watermark is prohibited.</li>" +
//                "<li> If any of the rules mentioned is violated the participant is deemed to be disqualified.<li>" +
//                "<li> By agreeing to participate the participant agrees that in case of any dispute arising with regard to the photo credits or objection raised by subjects captured in the photographs post submission, APERTURE will not hold responsibility for the same.</li> " +
//                "<li> Change of rules and/or time and acceptability of entries are at the discretion of the Organizing Committee members.</li>" +
//                "</ul>",
//                1,1,100,0,"N/A","N/A",clubUniqueIds[0],"N/A","N/A");
//                eventData=mDatabase.push();
//                eventData.setValue(newEvent);
//                newContact.Name = "Shubham Upreti";
//                newContact.Number = "7073527261";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Tanya Rai";
//                newContact.Number = "7073844898";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Maheeka Kaistha";
//                newContact.Number = "9811052395";
//         eventData.child("Contact").push().setValue(newContact);
//
//
//
//        newEvent.Time = "N/A";
//        newEvent.Location = "N/A";
//
//
//
//        newEvent.Name = "Pandora's-Box";
//        newEvent.Details = "Pick up a camera. Shoot something. <br>No matter how small,<br>No matter how cheesy,<br>No matter whether your friends <br>And your sister star in it.<br>Put your name on it<br>As director.Now you are a director.<br>Everything after that <br>" +
//                "you are just negotiating your budget and your fee.<br>" +
//                "                                    -James Cameron<br><br>" +
//                "Do you call yourself a passionate lover of classy cinema, do you want to be the initiator of change in the society or do you want to take this world on an adventure? You are free to do any of the above with the help of your lens; you are free to show us what do you want us to see but you have only 25 minutes. Just make a short film or a documentary, upload it on youtube and send it's link to us before 6th October 2017 11:59:59 pm.";
//        newEvent.Rules ="<ul>" +
//                "<li> Time limit: 2 minutes-25 minutes.</li>" +
//                "<li> Negetive marks will be awarded for exceeding the time limit.</li>" +
//                "<li> Participants are supposed to upload the film on their youtube channel and the link has to be submitted on our online form.</li>" +
//                "<li> The film can be in any language.</li>" +
//                "<li> English subtitles should be provided</li>" +
//                "<li> There is no restriction on the theme</li>" +
//                "<li> The link should be sent before 6th October 2017 11:59:59 PM.</li>" +
//                "<li> Multiple entries are allowed.</li>" +
//                "<li> Plagiarism is strictly prohibited</li>" +
//                "<li> The content of the movie should be appropriate for public screening and thus have no vulgarity.</li>" +
//                "<li> Entries must be the original work of the entrant and must not infringe third-party's rights.</li>" +
//                "<li> The organizing committee can, at any stage mend the rules and/or disqualify your entry.</li>" +
//                "<li> Watermarks are strictly not allowed on any of the films. Entries with watermarked films will be immediately disqualified.</li>" +
//                "<li> The team details are to be submitted in the following format-1. College name, 2. Team member details.</li>" +
//                "<li> The official mail id for this event would be cinefiliamuj@gmail.com</li>" +
//                "<li> Participants are required to send the link on cinefiliamuj@gmail.com as well.</li>" +
//                "<li> Keep checking the fest website for further information. www.oneiros.co.in</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 9;
//        newEvent.MaxParticipant = 20;
//        newEvent.Fees = 300;
//        newEvent.FeesMode = 1;
//        newEvent.JudgingCriteria =  "<ul>" +
//                "<li> Creativity</li>" +
//                "<li> Direction</li>" +
//                "<li> Scripting(Originality)</li>" +
//                "<li> Cinematography</li>" +
//                "<li> Execution</li>"+
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[0];
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact = new Contact(); newContact.Name = "Mahrishi Bisani";
//        newContact.Number = "9840741386";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Ambuj Agrawal";
//        newContact.Number = "8586915820";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//
////
//        newEvent = new Event("Focus",
//                "aperture, The Official Photography Club of MUJ brings you the third edition of our three day long annual photography exhibit ion, FOCUS. The exhibition will feature some of the best photographs captured by the talented shutterbugs of Manipal University Jaipur.<br>Photos will be called as entries in an event on aperture's official Facebook page (www.facebook.com/aperturemuj).<br>This can be a platform to showcase your talent. FOCUS is a celebration of the democratic nature of photography and hence will be an open themed group photo show.",
//                "Rules and Regulations: <ul>" +
//                        "<li> Entries can be monochrome, black and white or color.</li>" +
//                        "<li> The images must solely be the work of entrark and the entrant must have the copyright to exhibit these. aperture reserves the right to accept or refuse work submitted. No individual assessment of images will be made available and the decision of selectors will be final</li>" +
//                        "<li> Change of rules and/or time and acceptability of entries are at the discretion of the Organizing Committee member.</li>" +
//                        "<li> Copyright: If the image is selected by aperture, the entrant agrees and authorizes aperture to create copies, hang or use on walls/inter</li>" +
//                        "<li> net, books or publication or in any document and/or media created by aperture. In such usage, aperture will give due credit to the participant. Entrant also agrees, that aperture may use selected/exhibited work to promote photography and/or the photographer at its discretion.</li>" +
//                        "<li> Entry fees: There is no fee of any kind to enter the exhibition. If your image is selected for the exhibition, aperture will cover all the cost of printing, framing etc. The entrant has the option of taking the printed and/or framed images after the exhibition after paying for the cost incurred in printing and framing.</li>" +
//                        "<li> Please do not mark your images with any kind of watermark (your name, copyright sign etc). Any image containing any watermark will not be considered for the exhibition.</li>" +
//                        "<li> The image submitted by you should not obscene or vulgar and do not contain any identifiable information about you or any third person </li>" +
//                        "<li> You have taken adequate permission and rights from the model(s), authority to submit the image for  the exhibition </li>" +
//                        "<li> Each participant can submit a maximum of 3 images.</li>" +
//                        "<li> High resolution copy of the photograph should be present with the photo</li> " +
//                        "<li> There is no theme for the exhibition. Overall the exhibition should reflect the heterogeneity in creative expression by all those that  are participating</li>" +
//                        "<li> Every photograph posted must have the following information along with it.<br>1)Name<br>2)Cource<br>3)Year<br>4)EXIF data {for DSLR/bridge category)<br>5)Location (where the photograph has been clicked.)</li>" +
//                        "</ul> "
//                ,1,1,0,0,"N/A","N/A",clubUniqueIds[0],"N/A","N/A");
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//                newContact = new Contact();
//        newContact.Name = "Tushar Varma";
//        newContact.Number = "9772222757";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Simran Manchanda";
//        newContact.Number = "7073848401";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Geetika Mittal";
//        newContact.Number = "7597511960";
//        eventData.child("Contact").push().setValue(newContact);
//        newEvent.Time = "N/A";
//        newEvent.Location = "N/A";
//
////
////
////
////
////
////
////
////
////
////
////
////    //    Shabdh
////
////
////
////
////
//        newEvent= new Event(
//                "Izhaar",
//                "Poetry is that genre of literature which cascades down to the inner core of the heart effortlessly and is capable of bringing about sea changes in human psyche. Poetry is at its best when recited live before the audiences that is why Hindi club of MUJ is organizing Kavi Sammelan – IZHAAR. We give you a platform, come forward and share the memories of your childhood. Poems could be self written or copied from any author. Come and relive the joys of your childhood again."
//                ,"It is an individual event, where the participant will have to recite a poem based on the theme &quot;reminiscence of childhood&quot;" +
//                " the poems should be written fully in Hindi without any slangs/offensive terms. Although the theme is fixed but if there is anything else " +
//                "you would like to express your feeling about, you can! You are open to reciting poems on any topics, whatever expresses your feeling in the" +
//                " best way! The event shall be judged by two well-known poets, good luck fellas!",1,1,100,0,"<ul>" +
//                "<li>The participant will be judged on the quality of the matter and the way he expresses himself</li>" +
//                "<li>Language used shall be strictly Hindi</li>" +
//                "<li>No objection shall be entertained as the decision of the judge shall be final.</li>" +
//                "</ul>","N/A",clubUniqueIds[5],"N/A","N/A");
//                eventData=mDatabase.push();
//                eventData.setValue(newEvent);
//                newContact.Name = "Tanuj Jain";
//                newContact.Number = "7733089426";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Anushka";
//                newContact.Number = "8989810284";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Prattek Joseph";
//                newContact.Number = "9166355282";
//                eventData.child("Contact").push().setValue(newContact);
//
//        newEvent.Name = "Qissa-e-Dastan";
//        newEvent.Time = "N/A";
//        newEvent.Location = "N/A";
//
//        newEvent.Details = "&quotThere are too many idea and things and people, too many directions to go. I was starting to believe the reason it matters care passionately about something is that it whittles the world down to more manageable size.&quot-Charlie Kaufman (From Adaption)<br>" +
//                "We all have some stories to share, we all wanted to be storytellers at some point of time in our lives. Why not pen it down and mark it up with others, why not subject your emotions to the expression. We bring you a stage where we all storytellers unite to mark our thoughts and emotions to subject the art of storytelling.";
//        newEvent.Rules ="<ul>" +
//                "<li> The event is strictly online, hence last day of submission of your script is the second day of the Fest, i.e. _______’2017</li>" +
//                "<li> The script should be original and creative, Plagiarism is not tolerated under any circumstances.</li>" +
//                "<li> The script preferably should be based on the theme of the fest, reminiscence.</li>" +
//                "<li> You can start submitting your scripts by 1st Oct. 2017</li>" +
//                "<li> There is complete creative liberty, it’s the storytelling which counts.</li>" +
//                "<li> The language subjected for content can be either English or Hindi. </li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel or cut-short the event</li>" +
//                "<li> Decisions of the jury are final and no requests for reconsideration will be entertained.</li>" +
//                "<li> All participants are supposed to mail their entries to the email id provided below.</li>" +
//                "<li> Email ID - shabdcluboc@googlegroups.com</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 1;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 1;
//        newEvent.JudgingCriteria =  "<ul>" +
//                "<li> Creativity</li>" +
//                "<li> Content</li>" +
//                "<li> Plot,character development etc.</li>" +
//                "<li> Storytelling capabilities</li>" +
//                "<li> Realism</li>"+
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[5];
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact = new Contact(); newContact.Name = "Pratyushraj Singh Sisodia(Cinefilia)";
//        newContact.Number = "9479857756";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Arjun Gupta(Shabd)";
//        newContact.Number = "8199999453";
//        eventData.child("Contact").push().setValue(newContact);
//
//        newEvent.Time = "N/A";
//        newEvent.Location = "N/A";
//
//        newEvent = new Event("Chakravyuh",
//                "Are you fond of movies? Do you believe you know each and every fact about all your favorite movies? Let’s find out !",
//                "<ul>" +
//                        "<li> Music -This round will consist of 10 questions, where songs of popular movies (Hollywood/Bollywood) will be played and the team members will have to guess and write down the name of the movies on the provided piece of paper.</li>" +
//                        "<li> Dialogues->This round will consist of 10 questions, where songs of popular movies (Hollywood/Bollywood) will be played and the team members will have to guess and write down the name of the movies on the provided piece of paper.</li>" +
//                        "<li> Rapid Fire ->This round will consist of 10 questions, where songs of popular movies (Hollywood/Bollywood) will be played and the team members will have to guess and write down the name of the movies on the provided piece of paper.</li>" +
//                        "</ul>"
//                ,0,0,50,1,
//                        "<ul>" +
//                        "<li> Teams need to write down the correct answers of at least 6 questions out of 10 questions in Round 1, to qualify for Round 2.</li>" +
//                        "<li>Qualified Teams appearing for Round 2 will have to write down the correct answers for at least 8 out of 15 questions to Qualify for Round 3.</li>" +
//                        "<li>The team who get  maximum points will win</li>" +
//                        "</ul>",
//                "N/A",clubUniqueIds[5],"N/A","N/A");
//                eventData=mDatabase.push();
//                eventData.setValue(newEvent);
//                newContact.Name = "Anwesha Pal";
//                newContact.Number = "9867617115";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Shushank";
//                newContact.Number = "9660334616";
//                eventData.child("Contact").push().setValue(newContact);
//
//
//
//
//
//
//
//
//   //     Sophia
//
//
//
//
//        newEvent = new Event("Battleground",
//                "Passionate speaker, good thinker, quick reflex in generating ideas or a potential leader, think and then speak up on the surprise topic given, pick your fate from the topic bowl and speak on it.",
//                "A team event with teams consisting of 2 members each,where random topics will be given to the team with two minutes to ponder and three events each to speak there heart out. One team member will speak on the positive aspect and the other to speak on the negetive aspect of the topic. Two judges will decide the winners."
//                ,2,2,200,1,
//                "<ul><li>Each team member shall be given three minutes to speak on a topic picked up by him/her by draw of lots (Total: 6 + 2 = 8 minutes).</li>" +
//                        "<li>A bell will ring at the end of two minutes to indicate that one minute is left to finish his/her speech.</li>" +
//                        "<li>Another bell will ring at the end of three minutes.<br>Marks will be deducted if the speaker exceeds the time limit.</li>" +
//                        "<li>Participants must carry their own pens.</li>" +
//                        "<li>Language used shall be strictly English</li>" +
//                        "<li>No objection shall be entertained as the decision of the Judges shall be final</li>" +
//                        "</ul>",   "N/A", clubUniqueIds[6],"N/A","N/A" );
//                        eventData=mDatabase.push();
//                        eventData.setValue(newEvent);
//                        newContact.Name = "Devansh Agarwal";
//                        newContact.Number = "9660310624";
//                        eventData.child("Contact").push().setValue(newContact);
//                        newContact.Name = "Shounak Bhattacharya";
//                        newContact.Number = "9643460090";
//                        eventData.child("Contact").push().setValue(newContact);
//
//
//        newEvent = new Event("Sophia Circle",  "Like to discuss what is happening around, have solution in your mind or do the events around the world bothers you? Here is the platform to discuss what is going around in your mind and beleive us, this time, your thoughts and ideas will earn you some bucks.Give your best!<bt>An individual event where a topic will be given with 5 minutes to think and then an open group discussion where a panel of judges will decide the winners. The topic given will be a surprise for the participants and an anchor (from the club) will conduct the whole discussion with the help and supervision of faculty.",
//                "N/A",      1,1,100,0,
//                        "<ul>" +
//                        "<li> The participant should not interrupt one another.</li>" +
//                        "<li> The participants should challenge one another, but do so respectfully.</li>" +
//                        "<li> The participant should speak from their own experience, without generalizing.</li>" +
//                        "<li> The participant will be judged on the quality of matter spoken.</li>" +
//                        "<li> Verbal as well as non-verbal communication between participants.</li> " +
//                        "<li> Clarity of thought and presentation of ideas.<li>" +
//                        "<li> Participants must carry their own pens.</li>" +
//                        "</ul>",
//                "N/A",clubUniqueIds[6],"N/A","N/A");
//                eventData=mDatabase.push();
//                eventData.setValue(newEvent);
//                newContact.Name = "Neha Kangralkar";
//                newContact.Number = "9482197740";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Divya Bhardwaj";
//                newContact.Number = "988732459";
//                eventData.child("Contact").push().setValue(newContact);
//
//                newEvent.Club = clubUniqueIds[6];
//                newEvent.Name = "Relive & Revamp";
//                newEvent.Details = "Do you have the knack to race against time? Do you want to get the adrenaline surging through your veins? Then relive the past and create your own timeline. The aim of this game is to survive.";
//                newEvent.Rules = "<ul>" +
//                        "<li> This is a team event with teams consisting of 3-4 members. There will be a finite number of rounds. In each round, you will be presented with a scenario and then offered two choices. The decisions you make determine whether you survive or perish. You should always base your decisions on nothing more than the desire to keep yourself in existence. Also, each scenario should be taken at face value. At the end of the game you will discover if you have stayed alive or not, although, being a philosophical game, the verdict won't be straightforward.</li>" +
//                        "</ul>";
//                newEvent.JudgingCriteria = "<ul>" +
//                        "<li>The team that reaches the destination fastest wins!</li>" +
//                        "<li>Your fast thinking and decision making skills will make you the winner</li>" +
//                        "<li>If there is a tie between two teams, a tie breaker round with a different scenario will be given. The fastest team wins!</li>" +
//                        "<li>Participants must carry their own pens.</li>" +
//                        "</ul>";
//                newEvent.Fees = 300;
//                newEvent.MinParticipant = 3;
//                newEvent.MaxParticipant = 4;
//                newEvent.FeesMode = 1;
//                newEvent.Duration="N/A";
//                eventData=mDatabase.push();
//                eventData.setValue(newEvent);
//                newContact.Name = "Sadvansha Munshi";
//                newContact.Number = "9565793777";
//                eventData.child("Contact").push().setValue(newContact);
//                newContact.Name = "Shivam Ghungarde";
//                newContact.Number = "8655299405";
//                eventData.child("Contact").push().setValue(newContact);
//
//
//        newEvent.Time = "N/A";
//        newEvent.Location = "N/A";
//
////
////        //Coreographia
////
//        newEvent.Name="Nextar: Solo / Duet Dance Competition";
//        newEvent.Details="Dance is a language beyond words, expressing that for which we have no words. A bigger, better and more competitive than ever, Nextar awaits spectacular dancers with unmatched passion to perform and rock the stage like there's no tomorrow. So go Solo or Pair Up! And get in line to join the race to become the NEXTAR.";
//        newEvent.Club=clubUniqueIds[2];
//        newEvent.Duration="N/A";
//        newEvent.Fees=200;
//        newEvent.FeesMode=0;
//        newEvent.Rules="<ul>" +
//                        "<li> Two categories- Solo & Duet</li>" +
//                        "<li> Two rounds per category- Preliminary & final</li>" +
//                        "<li> Each participant (including both the members of a duet) needs to get themselves registered</li>" +
//                        "<li> Registrations will close 2 hours prior to the event</li>" +
//                        "<li> The registration fee shall not be refunded for any reason</li>" +
//                        "<li> Maximum Duration of Performance in the Preliminary round:" +
//                        "<ul>" +
//                        "<li> Solo: 1 minute</li>" +
//                        "<li> Duet: 1 minute 30 seconds</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<li> Maximum Duration of the Final round:" +
//                        "<ul>" +
//                        "<li> Solo: 3 minutes</li>" +
//                        "<li> Duet: 4 minutes</li>" +
//                        "</ul>" +
//                        "</li>" +
//                        "<li> No additional time will be allotted for rehearsal before the performance.</li>" +
//                        "<li> Exceeding the time limit mentioned above shall lead to negative marking or may even result in disqualification of the performer(s) by the Chairman of the Jury.</li>" +
//                        "<li> Use of Talcum Powder on the stage or on the body, or the use of Fire, Candles or any Liquid is strictly forbidden.</li>" +
//                        "<li> No Props are allowed.</li>" +
//                        "<li> Theme of the Choreography is free.</li>" +
//                        "<li> Choice of Music track and Dance form is open for all.</li>" +
//                        "<li> Music track for Preliminary and Final rounds may be different.</li>" +
//                        "<li> If the Music track prepared for the Final round is same as the one being used in the preliminary round, the track will be stopped at 1 minute for SOLO and 1 minute 30 seconds for DUET in the Preliminary round.</li>" +
//                        "<li> Participants are requested to bring their track(s) on at least 3 devices, such as Pen drives and Mobile phones, in order to avoid Technical disturbances.</li>" +
//                        "<li> No form of Vulgarity or Indecency should be expressed in the performance.</li>" +
//                        "<li> Misbehavior or Disregard of any rule on part of the participants will not be tolerated and can lead to Disqualification.</li>" +
//                        "<li> Decision of the Jury will be absolute and binding</li>" +
//                        "<li> In case of any Irregularity or Unavoidable situation, the Organizing Committee of the Event has the right to Modify or Cancel a performance.</li>" +
//                        "</ul>";
//        newEvent.MaxParticipant=2;
//        newEvent.MinParticipant=1;
//        newEvent.JudgingCriteria="<ul>" +
//                "<li> Performance: Effort, personality</li>" +
//                "<li> Technique: Transitions, Cleanliness, Execution</li>" +
//                "<li> Choreography: Difficulty, Musicality, Tricks</li>" +
//                "<li> Creativity: Originality, Artistic Choices and Dynamics</li>" +
//                "<li> Presentation: Crowd Appeal, Impact.</li>" +
//                "</ul>";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Shrawani Menghal";
//        newContact.Number="9874771545";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Shashwat Rastogi";
//        newContact.Number="9660680897";
//        eventData.child("Contact").push().setValue(newContact);
////
////
//        newEvent.Time = "N/A";
//        newEvent.Location = "N/A";
//
//        newEvent.Name="GROUND ZERO: All Style Hip – Hop Battle";
//        newEvent.Details="Manipal University Jaipur presents GROUND ZERO, an All Style Hip Hop team dance battle. Its time to resurface the underground competition for the best All- Style performers. Represent your college in a battle for total dominance.  Winner takes it all!";
//        newEvent.Club=clubUniqueIds[2];
//        newEvent.Duration="N/A";
//        newEvent.Fees=800;
//        newEvent.FeesMode=1;
//        newEvent.Rules="<ul>" +
//                "<li> All participants are requested to report 2 hours prior to the commencement of the event.</li>" +
//                "<li> Every participant should carry their respective college/school/institution ID's.</li>" +
//                "<li> No participant should indulge in any kind of physical or verbal abuse (slogans on clothing, nicknames etc) at any instance (before during or after event) thereby maintaining the decorum of the event. Any intentional physical contact will result in the competitor’s crew forfeiting the battle. In case of any sort of disturbance created by a participant, a warning will be given to the particular team, and further breaking of rules will lead to disqualification from the event.</li>" +
//                "<li> Wearing a pair of shoes is mandatory for the participants.</li>" +
//                "<li> No props are allowed.</li>" +
//                "<li> The decision of the judges will be final and absolute. Any arguments regarding the results will not be entertained.</li>" +
//                "<li> All battle and management related decisions will be in the hands of the Organizing Committee.</li>" +
//                "<li> Team limit: 5-10 members</li>" +
//                "<li> Max time limit per round: 3 mins</li>" +
//                "</ul>";
//        newEvent.MaxParticipant=10;
//        newEvent.MinParticipant=5;
//        newEvent.JudgingCriteria="<ul>" +
//                "<li> Dance Technique and Execution</li>" +
//                "<li> Musicality</li>" +
//                "<li> Personality: Character and Expressions</li>" +
//                "<li> Creativity and Skills</li>" +
//                "<li> Presentation: Crowd Appeal and Impact</li>" +
//                "</ul>";
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name="Aditya Pratap Singh";
//        newContact.Number="9660249491";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name="Vatsala Verma";
//        newContact.Number="9910024811";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "Showcase: Impromptu Solo/Duet";
//        newEvent.Details = "The Impromptu dance challenge for all talented dancers to SHOWCASE your skills. Reminisce and enjoy your golden minute of spotlight. Come in 1s, come in 2s, just put on your dancing shoes!<br>" ;
//        newEvent.Rules = "<ul>" +
//                "<li> On the spot solo/duet event</li>" +
//                "<li> All participants must carry their college/institution/school ID’s at all times</li>" +
//                "<li> Songs will be allocated on the spot on first-come-first-serve basis</li>" +
//                "<li> Participants are recommended to carry earphones/headphones</li>" +
//                "<li> Have empty storage space on your mobile devices (Songs will be transferred to the mobile phones)</li>"+
//                "<li> No songs will be repeated</li>" +
//                "<li> Songs will be allocated only once registration has been completed.</li>" +
//                "<li> Songs once given cannot be changed. Any change from the original song will result in disqualification.</li>" +
//                "<li> Registrations will close 2 hours prior to the event</li>"+
//                "<li> All participants are recommended to reach the venue 40 minutes prior to the event</li>"+
//                "<li> Misbehaviour of contestants will lead to disqualification.</li>"+
//                "<li> After registration there will be no refunds</li>"+
//                "<li> In case of any Irregularity or Unavoidable situation, the Organizing Committee of the Event has the right to Modify or Cancel a performance.</li>"+
//                "</ul>";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 1;
//        newEvent.Fees = 100;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Performance: Effort, personality</li>" +
//                "<li> Technique: Transitions, Cleanliness, Execution</li>"+
//                "<li> Choreography: Difficulty, Musicality, Tricks</li>"+
//                "<li> Creativity: Originality, Artistic Choices and Dynamics</li>" +
//                "<li> Presentation: Crowd Appeal, Impact.</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[2];
//        eventData.setValue(newEvent);
//        newContact.Name = "Kanika Jain";
//        newContact.Number = "9660204230";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Rhythm Balooni";
//        newContact.Number = "9660205740";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//
//        //TMC
//
//        eventData=mDatabase.push();
//        newEvent.Name = "RAPSODY";
//        newEvent.Details = "Rap motivates, humors and liberates people through poetry.<br>" +
//                "Rap has been an integral part of hip hop since the culture's early years.<br>" +
//                "RapSody is a platform for underdog rappers to showcase their artistry and skills in spitting rhymes.<br>" +
//                "We welcome rappers from around different cities, backgrounds and cultures to be a part of this movement and make Rap Wars more fun and entertaining at the same time.<br>" +
//                "So, who has got that fire? Who owns the mic? Show them all, what you can do!<br>" ;
//
//        newEvent.Rules = "<strong>Preliminary Round</strong>" +
//                "<ul>" +
//                "<li> Time limit – 90 seconds.</li>" +
//                "<li> No language barrier.</li>" +
//                "<li> No backing track.</li>" +
//                "<li> The participant may freestyle, use original content (preferred) or use content from other songs.</li>"+
//                "<Strong>Final Round</strong>"+
//                "<li> Time limit – 2-3 minutes.</li>" +
//                "<li> Participant would be given a backing track to perform impromptly on against each other</li>" +
//                "<li> The participant may freestyle, use original content (preferred) or use content from other songs.</li>" +
//                "<li> Four Participants will be selected for a semi-final round comprising of 2 face-offs and the winners will move on to the final round.</li>" +
//                "</ul";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 1;
//        newEvent.Fees = 150;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Technique</li>" +
//                "<li> Originality</li>" +
//                "<li> Rythm</li>" +
//                "<li> Enunciation</li>" +
//                "</ul";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[7];
//        eventData.setValue(newEvent);
//        newContact.Name = "Adhiraj Mani";
//        newContact.Number = "8826252398";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Samriddhi Kohli";
//        newContact.Number = "9660407467";
//        eventData.child("Contact").push().setValue(newContact);
//
//        // WoodStock
//
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "WoodStock";
//        newEvent.Details = "I have been imitated so well I have heard people copy my mistakes. - Jimi Hendrix<br>" +
//                "The Instrumental competition is here to make its mark.<br>" +
//                "Blaze a trail on stage and exuberate brilliance.<br>" ;
//
//        newEvent.Rules = "<ul>" +
//                "<li> Backing tracks are allowed.</li>" +
//                "<li> Keyboard and Drums will be provided.</li>" +
//                "<li> Time Limit is 7 minutes including Sound-Setup.</li>" +
//                "<li> The participant must strictly abide by the given time limit.</li>"+
//                "<li> There can be a maximum of 3 people in a performance.</li>" +
//                "<li> The decision of the judges will be final and binding.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel the event prior to its initiation.</li>" +
//                "</ul";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 3;
//        newEvent.Fees = 150;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Timing/Tightness</li>" +
//                "<li> Technique/Skill</li>" +
//                "<li> Stage Presence</li>" +
//                "<li> Creativity</li>" +
//                "</ul";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[7];
//        eventData.setValue(newEvent);
//        newContact.Name = "Shivang Pawar";
//        newContact.Number = "7023704087";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Devansh Shrivastava";
//        newContact.Number = "9799770113";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "FUNTAKSHARI";
//        newEvent.Details = "An event that does not need any introduction. We present, FUNTAKSHARI, the Antakshari event where we guarantee you loads of fun. So be a part of this event filled with thrill and excitement where we test your knowledge of Bollywood music industry.<br>" +
//                "Even if you're a singer or not, we will entertain all you movie buffs.Think you have got what it takes to be the champ? ‘Cause the event, though entertaining, would be hard to crack!<br>";
//        newEvent.Rules = "<ul>" +
//                "<li> A team must have a 3-4 members.</li>" +
//                "<li> There will be 4 rounds in total, each one offering a different challenge. Only Bollywood songs are allowed.</li>" +
//                "<li> Repetition of songs is not allowed in any of the rounds.</li>" +
//                "<li> If a team is not able to answer correctly, the question may be passed to the next team depending on the round.\"</li>"+
//                "<li> Songs should be lyrically correct. Although, minor mistakes might be overlooked.</li>" +
//                "<li> Judging criteria will depend on the rules of each round. However there is no overall negative marking.</li>" +
//                "<li> Proper code of conduct is expected from the participating teams.</li>"+
//                "<li> Use of mobile phones or any other device is strictly prohibited</li>"+
//                "<li> Rules of each round will be disclosed before the event.</li>"+
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel the event prior to its initiation.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 3;
//        newEvent.MaxParticipant = 4;
//        newEvent.Fees = 400;
//        newEvent.FeesMode = 1;
//        newEvent.JudgingCriteria = "N/A";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[7];
//        eventData.setValue(newEvent);
//        newContact.Name = "Shivansh Aggrawal";
//        newContact.Number = "9582083873";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Reema Saxena";
//        newContact.Number = "9660419332";
//        eventData.child("Contact").push().setValue(newContact);
//
//
////  //        TWICE THE VOICE
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "TWICE THE VOICE";
//        newEvent.Details = "Hear the harmonies collide as you embark on a journey with your partner to leave the crowd behind with the consonance of two voices. Realize the symmetry and manipulate it as you work towards a common goal of achieving rhythmic resonance, as you show off your chemistry.<br>" +
//                "SO WHAT’S STOPPING YOU<br>" +
//                "Get up, get set and get going. Sing your heart out!<br>" ;
//        newEvent.MinParticipant = 2;
//        newEvent.MaxParticipant = 2;
//        newEvent.Fees = 250;
//        newEvent.FeesMode = 1;
//        newEvent.Rules="<ul>" +
//                "<li> The Competition has only 1 round.</li>" +
//                "<li> Time limit is 5 minutes, including the set up time.</li>" +
//                "<li> At most one accompanist or karaoke is allowed.</li>" +
//                "<li> If time limit is exceeded, negative marks would be awarded.</li>" +
//                "<li> Reading the lyrics is not allowed.</li>"+
//                "<li> The decision of the judges is final and binding.</li>" +
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or" +
//                "cancel the event prior to its initiation.</li>" +
//                "<li> Only Keyboard will be provided for the participants.</li>"+
//                "<li> The contestants are required to bring the karaoke track in a pen drive or in" +
//                "mobile phones.</li>"+
//                "</ul>";
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Song Selection</li>" +
//                "<li> Technicalities</li>" +
//                "<li> Vocal Range</li>" +
//                "<li> Stage Presence</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[7];
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name = "Ishan Rawat";
//        newContact.Number = "9660236998";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Rashee Chandurkar";
//        newContact.Number = "9660391164";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//   /////      ENSEMBLE
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "ENSEMBLE";
//        newEvent.Details = "It is fun, if you are more than one! So calling out all the music enthusiasts, come along with the best of your buddies and be a part of this group singing event where you’ve got the stage to let the artist inside you out at its fullest.<br>" +
//                "So whether it’s your music maestro friend or the one who can just hum to the rhythm, bring ‘em all and let the melodies magnify!<br>";
//        newEvent.Rules = "<ul>" +
//                "<li> Minimum of 4 vocalists are compulsory.</li>" +
//                "<li> Maximum of 4 accompanists allowed.</li>" +
//                "<li> the registration fee for the first 10 participants is Rs.800,<br>" +
//                "Rs. 100 for every extra participant</li>" +
//                "<li> Each group will be allotted 10 minutes for their performance. (Including setup and sound check)</li>" +
//                "<li> The group must strictly abide by the time limit.</li>"+
//                "<li> A team member may sing and play an instrument as well. However, such a person would be counted both as a vocalist and an accompanist.</li>" +
//                "<li> Drums are not allowed.</li>" +
//                "<li> The decision of the judges shall be final and binding in all cases.</li>"+
//                "<li> This is a theme based event, the groups have to mention how they chose to interpret the theme before proceeding with their group performance.</li>"+
//                "<li> The performance can be a fusion, medley, acapella, etc. There is no language barrier.</li>"+
//                "<li> Keyboard and Tabla will be provided; other instruments have to be brought by the participant.</li>"+
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel the event prior to its initiation.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 4;
//        newEvent.MaxParticipant = 12;
//        newEvent.Fees = 800;
//        newEvent.FeesMode = 1;
//        newEvent.JudgingCriteria = "<li> Accordance with the theme. (reminscence)</li>"+
//                "<li> Quality of vocals</li>"+
//                "<li> Rhythm</li>"+
//                "<li> Synchronization</li>"+
//                "<li> Overall Impact (Stage Presence)</li>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[7];
//        eventData=mDatabase.push();
//        eventData.setValue(newEvent);
//        newContact.Name = "Poojitha Konduparti";
//        newContact.Number = "9680923350";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Gayathri Nair";
//        newContact.Number = "9660317916";
//        eventData.child("Contact").push().setValue(newContact);
//
//
//
//
//
//        // Bollywood
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "Bollywood";
//        newEvent.Details = "Music has one and singular language of sweetness worldwide and this event is to extract music from all the diverse styles. Bollywood genre is the most common and has a multitude of variety, having the maximum reach in the masses!<br>" +
//                "So what are you waiting for? BRACE UP FOR THIS MUSICAL EXTRAVAGANZA! Engross yourself in the soulful rendering of Bollywood music<br>";
//        newEvent.Rules = "<Strong>Preliminary Round" +
//                "<ul>" +
//                "<li> Time Limit is 2 minutes.</li>" +
//                "<li> No accompanist or karaoke allowed.</li>" +
//                "<li> If time limit is exceeded, negative marks would be awarded.</li>"+
//                "<li> Reading the lyrics is not allowed.</li>" +
//                "<li> Decision of the judges is final and binding.</li>" +
//                "</ul>" +
//                "<Strong>Final Round</Strong>" +
//                "<ul>" +
//                "<li> Time Limit is 5 minutes (Including Sound-Setup).</li>"+
//                "<li> Maximum of 2 Accompanists or a karaoke is allowed.</li>"+
//                "<li> If time limit is exceeded, negative marks would be awarded.</li>"+
//                "<li> Reading the lyrics is not allowed.</li>"+
//                "<li> Decision of the judges is final and binding.</li>"+
//                "<li> The participants are required to bring the karaoke tracks in a pen drive or in mobile phones.</li>"+
//                "<li> Only keyboard will be provided to the participants.</li>"+
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel the event prior to its initiation.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 1;
//        newEvent.Fees = 150;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Song Selection</li>"+
//                "<li> Technicalities</li>"+
//                "<li> Rhythm</li>"+
//                "<li> Vocal Range</li>"+
//                "<li> Stage Presence</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[7];
//        eventData.setValue(newEvent);
//        newContact.Name = "Ankita Tuli";
//        newContact.Number = "7738086399";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Christy Isadore";
//        newContact.Number = "8989441198";
//        eventData.child("Contact").push().setValue(newContact);
////
////
////
////
//        // OCTAVES
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
//        eventData=mDatabase.push();
//        newEvent.Name = "OCTAVES";
//        newEvent.Details = "Fill the air with ardent notes. Sing along in mellifluous tune. Here's your chance to bedazzle us with your musical talent! Oneiros‘17 presents to you our very own Western Solo Singing Competition. This event will provide you with a stage where you can showcase your singing skills.<br>" +
//                "So let the melodies proliferate!<br>";
//        newEvent.Rules = "<Strong>Preliminary Round</Strong>" +
//                "<ul>" +
//                "<li> Time Limit is  Maximum of 2 minutes.</li>" +
//                "<li> No accompanist or karaoke allowed.</li>" +
//                "<li> If time limit is exceeded, negative marks would be awarded.</li>" +
//                "<li> Reading the lyrics is not allowed.</li>"+
//                "<li> Decision of the judges is final and binding.</li>" +
//                "</ul>" +
//                "<Strong>Final Round</Strong>" +
//                "<ul>" +
//                "<li> Time limit is 6 minutes (Including Sound-Setup).</li>" +
//                "<li> Maximum of two Accompanists or a karaoke is allowed.</li>"+
//                "<li> If time limit is exceeded, negative marks would be awarded.</li>"+
//                "<li> Decision of the judges is final and binding.</li>"+
//                "<li> The participants are required to bring the karaoke tracks in a pen drive or in mobile phones.</li>"+
//                "<li> Only keyboard will be provided to the participants</li>"+
//                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel the event prior to its initiation.</li>" +
//                "</ul>";
//        newEvent.MinParticipant = 1;
//        newEvent.MaxParticipant = 1;
//        newEvent.Fees = 150;
//        newEvent.FeesMode = 0;
//        newEvent.JudgingCriteria = "<ul>" +
//                "<li> Song Selection</li>" +
//                "<li> Technicalities</li>"+
//                "<li> Vocal Range</li>"+
//                "<li> Stage Presence</li>" +
//                "</ul>";
//        newEvent.Duration = "N/A";
//        newEvent.Club  = clubUniqueIds[7];
//        eventData.setValue(newEvent);
//        newContact.Name = "Avantika Sharma";
//        newContact.Number = "9711622016";
//        eventData.child("Contact").push().setValue(newContact);
//        newContact.Name = "Atharv Dixit";
//        newContact.Number = "8308748222";
//        eventData.child("Contact").push().setValue(newContact);
////
//        // Saptak
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Events");
        eventData=mDatabase.push();
        newEvent.Name = "Saptak";
        newEvent.Details = "Rooted in the antiquity, Indian Classical Music portrays the rich cultural heritage of our country. <br>" +
                "Sur Taal, like its meaning can be visualized as the light spectrum and the musical notes depict the bright colours of the spectrum.<br>"+
                "This solo event gives you the opportunity to blend the seven notes into an alluring composition and showcase your versatility.<br>";
        newEvent.Rules = "<Strong>Preliminary Round</Strong>" +
                "<ul>" +
                "<li> Time Limit is 2 minutes.</li>" +
                "<li> No Accompanists are allowed.</li>" +
                "<li> Any Bollywood or Non-Bollywood Classical/Sufi/Folk/Ghazal/Bhajan can be performed..</li>" +
                "<li> If time limit is exceeded, negative marks would be awarded.</li>" +
                "<li> Reading the lyrics is not allowed.</li>"+
                "<li> Decision of the judges is final and binding.</li>" +
                "<li> Instrument will be there to provide Scale.</li>" +
                "</ul>" +
                "<Strong>Final Round</Strong>" +
                "<ul>" +
                "<li> Time Limit is 6 minutes (Including Sound-Setup).</li>" +
                "<li> Maximum of 2 Accompanists or a karaoke is allowed.</li>"+
                "<li> Any Bollywood or Non-Bollywood Classical/Sufi/Folk/Ghazal/Bhajan can be performed.</li>"+
                "<li> If time limit is exceeded, negative marks would be awarded.</li>"+
                "<li> Decision of the judges is final and binding.</li>"+
                "<li> The participants are required to bring the karaoke tracks in a pen drive or in mobile phones.</li>"+
                "<li> Harmonium/Keyboard/Tabla will be provided to the participants</li>"+
                "<li> The Organizing Committee has the right to mend rules, disqualify entries or cancel the event prior to its initiation.</li>" +
                "</ul>";
        newEvent.MinParticipant = 1;
        newEvent.MaxParticipant = 3;
        newEvent.Fees = 150;
        newEvent.FeesMode = 0;
        newEvent.JudgingCriteria = "<ul>" +
                "<li> Sur</li>" +
                "<li> Taal</li>"+
                "<li> Song Modulation</li>"+
                "<li> Stage Presence</li>" +
                "</ul>";
        newEvent.Duration = "N/A";
        newEvent.Club  = clubUniqueIds[7];
        eventData.setValue(newEvent);
        newContact.Name = "Abhinav Misra";
        newContact.Number = "9044955651";
        eventData.child("Contact").push().setValue(newContact);
        newContact.Name = "Swasti Chaturvedi";
        newContact.Number = "9660460606";
        eventData.child("Contact").push().setValue(newContact);

    }
}
