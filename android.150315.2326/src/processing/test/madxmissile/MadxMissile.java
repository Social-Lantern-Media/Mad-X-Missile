

package processing.test.madxmissile;

import processing.core.*; 

import android.os.Bundle;
import android.widget.LinearLayout;
import apwidgets.*; 
import java.util.*; 

import apwidgets.*; 


import java.util.ArrayList; 
import com.amazon.device.ads.AdLayout;
import com.amazon.device.ads.AdRegistration;

import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;



public class MadxMissile extends PApplet {


		
	private AdLayout adView;
		@Override
	   
		public void onCreate(Bundle savedInstanceState) {
			 
		    //we call this to make sure PApplet's onCreate() code gets called as well
		    super.onCreate(savedInstanceState);

		    /* Here we set up our app key and set the necessary debug options */
		    AdRegistration.setAppKey("ed5542d25c2e42d7aca94abc96fd9d39");
		   // AdRegistration.enableTesting(false);
		   // AdRegistration.enableLogging(false);

		    //create a new instance of an Amazon AdLayout object
		    adView = new AdLayout(this);

		    /* Here we create the container that holds the graphic overlay
		       of the ad. We set gravity to bottom to make it appear along the
		       bottom of the screen. */
		    LinearLayout layout = new LinearLayout(this);
		    layout.setGravity(Gravity.BOTTOM);

		    /* Here we are just defining the attributes of our AdLayout by creating
		       a new instance of LayoutParams for a FrameLayout. We'll then attach these
		       parameters to our AdLayout, which itself extends a FrameLayout */
		    FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
		            LayoutParams.MATCH_PARENT,
		            LayoutParams.WRAP_CONTENT,
		            Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL);

		    /* We add the AdLayout as a view (something to fill) our LinearLayout.
		       We also attach our LayoutParams to our adView */
		    layout.addView(adView, lp);

		    //make a call to the ad server to request a new ad
		    adView.loadAd();

		    /* add our LinearLayout, which contains our AdLayout, to the main
		       drawing screen (our PApplet, which is our main Activity) as an overlay */
		    addContentView(layout, lp);
		}
 
       

 

//import android.media.MediaPlayer;

PImage background1; 
PImage background2;
PImage backgroundruins; 
PImage backgroundruinsightmare;
PImage titlescreen;
PImage homescreen; 

PImage building1;
PImage building2;
PImage building3;
PImage building4; 
PImage building5;
PImage building6;




PImage alien1a;
PImage alien1b;
PImage alien2a;
PImage alien2b;
PImage alien3a;
PImage alien3b;
PImage alien4a;
PImage alien4b;

PImage friendlyrocket;
PImage satelite;
PImage satelitedeflect; 

PImage citybutton;

PImage infobutton;
PImage nightmarebutton;

PImage ratethis;
PImage sharethis;

PImage FlawlessBadge;
PImage DoomsdamBadge; 
PImage NewCityBadge;
PImage ScoreBadge;
PImage BonusBadge;

boolean flawlessbadge;
boolean doomsdaybadge; 
boolean NewCitybadge = false; 
boolean nightmareround = false;

//Minim minim;


APMediaPlayer intro;
APMediaPlayer end;
APMediaPlayer newcity; 
APMediaPlayer button; 
APMediaPlayer deflect; 

APMediaPlayer boom1; 
APMediaPlayer boom2; 
APMediaPlayer boom3; 
APMediaPlayer boom4; 
APMediaPlayer boom5; 
APMediaPlayer boom6; 
APMediaPlayer boom7; 
APMediaPlayer boom8; 
APMediaPlayer boom9; 
APMediaPlayer boom10; 

APMediaPlayer laser1; 
APMediaPlayer laser2; 
APMediaPlayer laser3; 


APMediaPlayer track1;
APMediaPlayer track2;
APMediaPlayer track3;
APMediaPlayer track4;
APMediaPlayer track5;
APMediaPlayer track6;
APMediaPlayer track7;
APMediaPlayer track8;



static final int DRAW_FPS = 60;
static final int PHYS_FPS = 180;
static final int FRATE = 800;

static final float MARCH_BPM = 35.793f;
static final int MARCH_FRAMES = (int) (PHYS_FPS * 60.0f / MARCH_BPM);

static final int DRAW_MILLS = 1000/DRAW_FPS;
static final int PHYS_MILLS = 1000/PHYS_FPS;


static final int EXPLOSION_DURATION = 180;
static final int EXPLOSION_SCALE = 30;
static final int EXPLOSION_BONUS = 20;

static final int INVADER_BLOCK_WIDTH = 11;
static final int INVADER_BLOCK_HEIGHT = 5;
static final int INVADER_X_SPACING = 48;
static final int INVADER_Y_SPACING = 48;
static final int INVADER_RADIUS = 16;
static final int MARCH_DISTANCE = 16;

static final int MARCH_RIGHT = 0;
static final int MARCH_DOWN_LEFT = 1;
static final int MARCH_LEFT = 2;
static final int MARCH_DOWN_RIGHT = 3;

static final int SHOT_DELAY_BASE = 180 * 18;
static final int START_DIFFICULTY = 6;
static final int DOOMSDAY_DIFFICULTY  = 12;

static final float STEER_FACTOR = 0.02f;

static final int NUM_CITIES = 6;
static final float CITY_SPACING = 100;
static final float CITY_RADIUS = 20;

static final int ANNOUNCE_TIME = 3 * PHYS_FPS;

static final int CITY_BONUS = 1000;
static final int FLAWLESS_BONUS = 3000;
static final int TIME_BONUS_SECS = 100;
static final int TIME_BONUS = 200;
static final int EXTRA_CITY_AT = 5000;
 int  hitscounter = 0; 
 int highscore = 5000; 

boolean nightmare; 
boolean bl1 = false;
boolean bl2 = false;
boolean bl3 = false;
boolean bl4 = false;
boolean bl5 = false;
boolean bl6 = false;
boolean ready = false; 


/////////// GLOBALS

static PVector[][] patterns;
PFont font;

int drawMark;
int drawingFrame;
int physicsFrame;
int physMark;

int ttx = 400-50; 
int tty = 350;
int chx = 400-50; 
int chy = 280;

int fbx = 170; 
int fby = 480;

int shx = 405; 
int shy = 480;

int hmx = 245; 
int hmy = 600;




ArrayList missiles;
ArrayList explosions;
ArrayList invaders;
boolean[] cities;

int playerX;
int playerY = 520;
int playerWidth = 120;
int playerHeight = 16;

int marchDir;
int difficulty;
int shotTimer;

int waveTimer;
String announceString;
String bonusString = "\n \n";

int score;
boolean flawlessDefense;
boolean doomsday = false;
boolean bounce;
int cityPoints;

boolean paused;
boolean gameOver;
boolean atTitle;
boolean firstLevel;

/////////// AUDIO






/////////// UTIL

public boolean inRadius(PVector a, PVector b, float rad)
{
  return rad*rad > (a.x - b.x)*(a.x - b.x) + (a.y - b.y) * (a.y - b.y);
}

public boolean inRadius(float ax, float ay, float bx, float by, float rad)
{
  return rad*rad > (ax - bx)*(ax - bx) + (ay - by) * (ay - by);
}



public float cityPos(int c)
{
  float y = height;
  float x = width/2 - ((NUM_CITIES-1)/2.0f)*CITY_SPACING + c*CITY_SPACING;
  return x;//new PVector(x, y);
}

/////////// CLASSES

class Missile
{
  boolean friendly;
  PVector origin;
  PVector pos;
  PVector vel;
  Missile(PVector from, PVector velocity, boolean friend)
  {
    friendly = friend;
    origin = new PVector(from.x, from.y);
    pos = new PVector(from.x, from.y);
    vel = new PVector(velocity.x, velocity.y);
  }
  public void move()
  {
    pos.add(vel);
    if (pos.x < 0 || pos.x > width)
    {
      if (pos.x < 0) pos.x=0;
      if (pos.x > width) pos.x=width;
      origin = new PVector(pos.x, pos.y);
      vel.x = - vel.x;
    }
    if (pos.y < 0)
    {
      origin = new PVector(pos.x, pos.y);
      vel.y = - vel.y;
    }
    if (vel.y > 0 && 
      pos.y > playerY-10 && 
      pos.y < playerY + playerHeight-10 &&
      pos.x > playerX - playerWidth/2 &&
      pos.x < playerX + playerWidth/2)
    {
      vel.y = - vel.y;

      friendly = true;
      origin = new PVector(pos.x, pos.y);
      vel.x = (pos.x - playerX)*STEER_FACTOR;
      bounce = false;
      deflect.start();
     // deflect.setLooping(true); 

      ///ADD DEFLECT sound
      /////////////////////////////////////////////////////////////////////
    } else {
    }
  }
  public void draw()
  {
    strokeWeight(2);
    if (friendly) stroke(5, 245, 22);
    else stroke(245, 5, 217);

    //missle trail
    line(origin.x, origin.y, pos.x, pos.y);
    fill(255);
    noStroke();

    //missle head
    ///***************Add rocket
    //image(friendlyrocket,pos.x,pos.y); 
    ellipse(pos.x, pos.y, 6, 6);
  }
}

class Explosion
{
  PVector pos;
  int level;
  int life;
  int maxlife;

  Explosion(PVector at, int lev)
  {
    level = lev;
    pos = new PVector(at.x, at.y);
    maxlife = life = EXPLOSION_DURATION * (level + 1);
  }

  public float radius()
  {
    int magn = (EXPLOSION_SCALE + EXPLOSION_BONUS * level) * 2;
    float lifeLeft = ((float)life) / maxlife;
    return min(magn * lifeLeft, magn * (1 - lifeLeft));
  }

  public void draw()
  {
    noStroke();

    //explosion
    fill(blastColor());

    ellipse(pos.x, pos.y, radius()*2, radius()*2);
    ///*** ADD EXPLOSION ANIMATION
  }
}

class Invader
{
  int al = (int)random(0, 4);

  final int row;
  final int column;
  PVector pos;
  final int strength;
  PVector[] pattern;
  Invader(int c, int r, int s)
  {
    strength = min(max(s, 0), 6);
    row = r;
    column = c;
    pos = new PVector(column * INVADER_X_SPACING + INVADER_RADIUS, row * INVADER_Y_SPACING + INVADER_RADIUS);

    //temp
    pattern = patterns[strength];
  }
  public boolean march()
  {
    boolean hitwall = false;
    if (marchDir == MARCH_LEFT)
    {
      pos.x -= MARCH_DISTANCE;
      if (pos.x <= INVADER_RADIUS + MARCH_DISTANCE) hitwall = true;
    } else if (marchDir == MARCH_RIGHT)
    {
      pos.x += MARCH_DISTANCE;
      if (pos.x >= width - (INVADER_RADIUS + MARCH_DISTANCE)) hitwall = true;
    } else
    {
      pos.y += MARCH_DISTANCE;
    }

    return hitwall;
  }
  public void draw()
  {
    int[] testColors = {
      color(255, 0, 0), color(255, 255, 0), color(0, 255, 0), color(0, 255, 255), color(0, 0, 255), color(255, 0, 255), color(255, 255, 255)
    };   //fill(testColors[strength]);
    fill(testColors[strength]);
    noStroke();
    //ellipse(pos.x, pos.y, INVADER_RADIUS*2, INVADER_RADIUS*2);
    pushMatrix();
    rectMode(CORNERS);

    translate(pos.x, pos.y);

    if ( nightmare == false && doomsday == true) { 

      if (al == 0 || al == 1 || al == 2 || al == 3) {

        if ((physicsFrame % MARCH_FRAMES) > MARCH_FRAMES/2)
        {
          image(alien4a, 0, 0, 40, 40);
        } else {
          image(alien4b, 0, 0, 40, 40);
        }
      }
    }

    if ( nightmareround == true && doomsday == false) {

if ( al == 0) {

        if ((physicsFrame % MARCH_FRAMES) > MARCH_FRAMES/2)
        {
          image(alien1a, 0, 0, 40, 40);
        } else {
          image(alien1b, 0, 0, 40, 40);
        }
      }

      if ( al == 1) {

        if ((physicsFrame % MARCH_FRAMES) > MARCH_FRAMES/2)
        {
          image(alien1a, 0, 0, 40, 40);
        } else {
          image(alien1b, 0, 0, 40, 40);
        }
      }

      if ( al == 2) {
        if ((physicsFrame % MARCH_FRAMES) > MARCH_FRAMES/2)
        {
          image(alien3a, 0, 0, 40, 40);
        } else {
          image(alien3b, 0, 0, 40, 40);
        }
      }

      if ( al == 3) {
        if ((physicsFrame % MARCH_FRAMES) > MARCH_FRAMES/2)
        {
          image(alien2a, 0, 0, 40, 40);
        } else {
          image(alien2b, 0, 0, 40, 40);
        }
      }
    }
rectMode(CORNER);
    popMatrix();
  }
  public void fireShot()
  {
    if (strength <= 0)
      missiles.add(new Missile(new PVector(pos.x, pos.y+INVADER_RADIUS), new PVector(0, 0.6f), false)); //straight down
    int ml = (int)random(1, 3);
    if (ml == 1 ) {
      laser1.start();
     // laser1.setLooping(true);
    }
    if (ml == 2 ) {
      laser2.start();
     // laser2.setLooping(true);
    }
    if (ml == 3 ) {
      laser3.start();
     // laser3.setLooping(true);
    } else if (strength == 1)
      missiles.add(new Missile(new PVector(pos.x, pos.y+INVADER_RADIUS), new PVector(random(0.6f)-0.3f, 0.6f), false)); //scatter


    else if (strength == 2)
    { //aim at random living or dead base
      int base = (int) random(NUM_CITIES);
      PVector origin = new PVector(pos.x, pos.y+INVADER_RADIUS);
      PVector target = new PVector(cityPos(base), height);
      PVector vel = PVector.sub(target, origin);
      vel.normalize();
      missiles.add(new Missile(origin, vel, false));
    } else if (strength == 3)
    { //aim at random living or dead base, banking shot off a wall
      int base = (int) random(NUM_CITIES);
      PVector origin = new PVector(pos.x, pos.y+INVADER_RADIUS);
      PVector target;
      if (random(2) < 1)target = new PVector(0 - cityPos(base), height);
      else target = new PVector(width * 2 - cityPos(base), height);
      PVector vel = PVector.sub(target, origin);
      vel.normalize();
      missiles.add(new Missile(origin, vel, false));
    } else if (strength == 4)
    { //aim fast shot at a random base, preferring living ones
      int base = (int) random(NUM_CITIES);
      for (int i = 0; i<5; i++) if (!cities[base]) base = (int) random(NUM_CITIES); //reroll for living city
      PVector origin = new PVector(pos.x, pos.y+INVADER_RADIUS);
      PVector target = new PVector(cityPos(base), height);
      PVector vel = PVector.sub(target, origin);
      vel.normalize();
      vel.mult(1.5f);
      missiles.add(new Missile(origin, vel, false));
    } else if (strength == 5)
    { //aim fast bank shot at a living base
      int base = (int) random(NUM_CITIES);
      for (int i = 0; i<5; i++) if (!cities[base]) base = (int) random(NUM_CITIES); //reroll for living city

      PVector origin = new PVector(pos.x, pos.y+INVADER_RADIUS);
      PVector target;
      if (random(2) < 1)target = new PVector(0 - cityPos(base), height);
      else target = new PVector(width*2 - cityPos(base), height);
      PVector vel = PVector.sub(target, origin);
      vel.normalize();
      vel.mult(1.5f);
      missiles.add(new Missile(origin, vel, false));
    } else missiles.add(new Missile(new PVector(pos.x, pos.y+INVADER_RADIUS), new PVector(random(4)-2, 1.7f), false)); //fast random shot
  }
  public void getHit()
  {
    explosions.add(new Explosion(pos, 0));

    int pl = (int)random(1, 10);
    if (pl == 1 ) {
      boom1.start();
    //  boom1.setLooping(true);
    }
    if (pl == 2 ) {
      boom2.start();
    //  boom2.setLooping(true);
    }
    if (pl == 3 ) {
      boom3.start();
    //  boom3.setLooping(true);
    }
    if (pl == 4 ) {
      boom4.start();
    //  boom4.setLooping(true);
    }
    if (pl == 5 ) {
      boom5.start();
    //  boom5.setLooping(true);
    }
    if (pl == 6 ) {
      boom6.start();
    //  boom6.setLooping(true);
    }
    if (pl == 7 ) {
      boom7.start();
    //  boom7.setLooping(true);
    }
    if (pl == 8 ) {
      boom8.start();
    //  boom8.setLooping(true);
    }
    if (pl == 9 ) {
      boom9.start();
    //  boom9.setLooping(true);
    }
    if (pl == 10 ) {
      boom10.start();
    //  boom10.setLooping(true);
    }

    ///ADD EXPLOSION SOUND
  }
}

/////////// PHYSICS

public void physicsStep()
{
  int citiesRemaining = 0;
  for (int i=0; i < NUM_CITIES; i++) if (cities[i]) ++citiesRemaining;
  //playerWidth = 60 + 10*citiesRemaining;

  updatePlayerPos();

  testExplosions();
  testMissiles();

  ///update explosions
  Iterator i = explosions.iterator();
  while (i.hasNext ())
  {
    Explosion e = (Explosion) i.next();
    e.life--;
    if (e.life <= 0) i.remove();
  }

  i = missiles.iterator();
  while (i.hasNext ())
  {
    Missile m = (Missile) i.next();
    m.move();
    if (m.pos.y > height-10) {
      i.remove();
      explosions.add(new Explosion(m.pos, 1));
      int pl = (int)random(1, 10);
      if (pl == 1 ) {
        boom1.start();
        //boom1.setLooping(true);
      }
      if (pl == 2 ) {
        boom2.start();
      //  boom2.setLooping(true);
      }
      if (pl == 3 ) {
        boom3.start();
       // boom3.setLooping(true);
      }
      if (pl == 4 ) {
        boom4.start();
       // boom4.setLooping(true);
      }
      if (pl == 5 ) {
        boom5.start();
       // boom5.setLooping(true);
      }
      if (pl == 6 ) {
        boom6.start();
       // boom6.setLooping(true);
      }
      if (pl == 7 ) {
        boom7.start();
      //  boom7.setLooping(true);
      }
      if (pl == 8 ) {
        boom8.start();
      //  boom8.setLooping(true);
      }
      if (pl == 9 ) {
        boom9.start();
      //  boom9.setLooping(true);
      }
      if (pl == 10 ) {
        boom10.start();
      //  boom10.setLooping(true);
      }

      flawlessDefense = false;
    } else if (invaders.isEmpty())
    {
      if (m.pos.y < 16) {
        i.remove();
        explosions.add(new Explosion(m.pos, 1));
        int pl = (int)random(1, 10);
        if (pl == 1 ) {
          boom1.start();
        //  boom1.setLooping(true);
        }
        if (pl == 2 ) {
          boom2.start();
       //   boom2.setLooping(true);
        }
        if (pl == 3 ) {
          boom3.start();
       //   boom3.setLooping(true);
        }
        if (pl == 4 ) {
          boom4.start();
       //   boom4.setLooping(true);
        }
        if (pl == 5 ) {
          boom5.start();
        //  boom5.setLooping(true);
        }
        if (pl == 6 ) {
          boom6.start();
        //  boom6.setLooping(true);
        }
        if (pl == 7 ) {
          boom7.start();
       //   boom7.setLooping(true);
        }
        if (pl == 8 ) {
          boom8.start();
       //   boom8.setLooping(true);
        }
        if (pl == 9 ) {
          boom9.start();
         // boom9.setLooping(true);
        }
        if (pl == 10 ) {
          boom10.start();
        //  boom10.setLooping(true);
        }
      }
    }
  }
  if (physicsFrame%MARCH_FRAMES == 0) marchInvaders();
  invaderThink();

  if (invaders.isEmpty() && missiles.isEmpty() && explosions.isEmpty() && !gameOver)
  {
    nextLevel();
  }

  physicsFrame++;
  waveTimer++;
}

public void testExplosions()
{
  ArrayList newExplosions = new ArrayList();

  Iterator ei = explosions.iterator();
  while (ei.hasNext ())
  {
    Explosion e = (Explosion) ei.next();
    float r = e.radius();
    Iterator vi = invaders.iterator();
    while (vi.hasNext ())
    {
      Invader v = (Invader) vi.next();

      if (inRadius(v.pos, e.pos, r))
      {
        vi.remove();
        score += min(100*(v.strength+1), 500);
        
        
        
        newExplosions.add(new Explosion(v.pos, 0));
      }
    }
    Iterator mi = missiles.iterator();
    while (mi.hasNext ())
    {
      Missile m = (Missile) mi.next();
      if (inRadius(m.pos, e.pos, r))
      {
        mi.remove();
        newExplosions.add(new Explosion(m.pos, 2));
      }
    }
    for (int i = 0; i < NUM_CITIES; i++) 
    {
      if (cities[i])
      {
        if (inRadius(e.pos.x, e.pos.y, cityPos(i), height, r))
        {
          cities[i] = false;
          
          
          newExplosions.add(new Explosion(new PVector(cityPos(i), height), 2));
          hitscounter++;
          int pl = (int)random(1, 10);
          if (pl == 1 ) {
            boom1.start();
           // boom1.setLooping(true);
          }
          if (pl == 2 ) {
            boom2.start();
           // boom2.setLooping(true);
          }
          if (pl == 3 ) {
            boom3.start();
           // boom3.setLooping(true);
          }
          if (pl == 4 ) {
            boom4.start();
           // boom4.setLooping(true);
          }
          if (pl == 5 ) {
            boom5.start();
           // boom5.setLooping(true);
          }
          if (pl == 6 ) {
            boom6.start();
          //  boom6.setLooping(true);
          }
          if (pl == 7 ) {
            boom7.start();
          //  boom7.setLooping(true);
          }
          if (pl == 8 ) {
            boom8.start();
          //  boom8.setLooping(true);
          }
          if (pl == 9 ) {
            boom9.start();
          //  boom9.setLooping(true);
          }
          if (pl == 10 ) {
            boom10.start();
          //  boom10.setLooping(true);
          }

          flawlessDefense = false;
        }
      }
    }
  }
  explosions.addAll(newExplosions);
}

public void testMissiles()
{
  Iterator im = missiles.iterator();
  while (im.hasNext ())
  {
    Missile m = (Missile) im.next();
    for (int i = 0; i < invaders.size (); i++)
    {
      Invader test = (Invader) invaders.get(i);
      if (inRadius(m.pos, test.pos, INVADER_RADIUS) && m.friendly)
      {
        test.getHit();
        PVector away = PVector.sub(m.pos, test.pos);
        away.normalize();
        away.mult(m.vel.mag());
        m.vel = away;
        m.origin = new PVector(m.pos.x, m.pos.y);
        PVector away2 = PVector.sub(m.pos, test.pos);
        away2.normalize();
        away2.mult(INVADER_RADIUS);
        m.pos = PVector.add(away2, test.pos);
      }
    }
  }
}

public void updatePlayerPos()
{
  playerX = mouseX;
  bounce = true;
  if (hitscounter == 6) {
    for (int i = 0; i < cities.length; i++) cities[i] = false;
      invaders.clear();
      missiles.clear();
      explosions.clear();
      
      gameOver = true;
      ready = false;
      track1.pause();
       track1.seekTo(0);
      track2.pause();
      track2.seekTo(0);
      track3.pause();
      track3.seekTo(0);
      track4.pause();
      track4.seekTo(0);
      track5.pause();
      track5.seekTo(0);
      track6.pause();
      track6.seekTo(0);
      track7.pause();
      track7.seekTo(0);
      track8.pause();
      track8.seekTo(0);

 
      end.start(); 
      end.setLooping(true);
      button.start();
            }
}

public void marchInvaders()
{
  boolean wall = false;
  for (int i = 0; i < invaders.size (); i++)
  {
    Invader v = (Invader) invaders.get(i);
    if (v.march()) wall = true;
  }
  if (wall)
  {
    if (marchDir == MARCH_LEFT) marchDir = MARCH_DOWN_RIGHT;
    else if (marchDir == MARCH_RIGHT) marchDir = MARCH_DOWN_LEFT;
  } else
  {
    if (marchDir == MARCH_DOWN_LEFT) marchDir = MARCH_LEFT;
    if (marchDir == MARCH_DOWN_RIGHT) marchDir = MARCH_RIGHT;
  }
}

public void detonateMissiles()
{
  boolean exploded = false;
  Iterator i = missiles.iterator();
  while (i.hasNext ())
  {
    Missile m = (Missile) i.next();
    if (m.friendly)
    {
      explosions.add(new Explosion(m.pos, 1));
      int pl = (int)random(1, 10);
      if (pl == 1 ) {
        boom1.start();
        boom1.seekTo(0);
      }
      if (pl == 2 ) {
        boom2.start();
        boom2.seekTo(0);
      }
      if (pl == 3 ) {
        boom3.start();
        boom3.seekTo(0);
      }
      if (pl == 4 ) {
        boom4.start();
        boom4.seekTo(0);
      }
      if (pl == 5 ) {
        boom5.start();
        boom5.seekTo(0);
      }
      if (pl == 6 ) {
        boom6.start();
        boom6.seekTo(0);
      }
      if (pl == 7 ) {
        boom7.start();
        boom7.seekTo(0);
      }
      if (pl == 8 ) {
        boom8.start();
        boom8.seekTo(0);
      }
      if (pl == 9 ) {
        boom9.start();
        boom9.seekTo(0);
      }
      if (pl == 10 ) {
        boom10.start();
        boom10.seekTo(0);
      }
      exploded = true;
      //ADD EXPLOSION RANDOMIZE SOUND 
      i.remove();
    }
  }
}

public void invaderThink()
{
  if (shotTimer <= 0 && !invaders.isEmpty())
  {
    shotTimer = SHOT_DELAY_BASE / difficulty;
    boolean blocked;
    Invader randInvader;
    do {
      int index = (int)random(invaders.size());
      randInvader = (Invader) invaders.get(index);
      blocked = false;
      for (int i = index+1; i < invaders.size (); i++)
      {
        Invader test  = (Invader) invaders.get(i);
        if (test.pos.x == randInvader.pos.x)
        {
          blocked = true; 
          break;
        }
      }
    }
    while (blocked);
    if (!blocked) randInvader.fireShot();
  }
  shotTimer--;
}

/////////// DRAWING

public void drawFrame()
{
  if (!atTitle)
  {
    if (!paused)drawingFrame++;
    background(0);
    ////**** INSERT BACKGROUND GAME IMAGE 



   
    drawCities();
    drawMissiles();
     drawPlayer(); 

    for (int i = 0; i< invaders.size (); i++)
    {
      Invader v = (Invader) invaders.get(i);
      v.draw();
    }

    for (int i = 0; i< explosions.size (); i++)
    {
      Explosion e = (Explosion) explosions.get(i);
      e.draw();
    }



    drawHud();
  } else
  {
    
    noStroke(); 
    fill(255); 
    image(nightmarebutton, 0, -50);
   
    noStroke(); 
    fill(255); 
    image(citybutton, 0, -60);
    image(infobutton, 4, 0); 
    image(ratethis, 6, 0);
     image(sharethis, 0, 0); 
  
  }
}

public void drawHud()
{

  noSmooth();
  textSize(16);
  fill(255);
  textAlign(LEFT, TOP);
  text("SCORE: "+score, 10, 10);




  int countdown = (int)max(TIME_BONUS_SECS - waveTimer/PHYS_FPS, 0);
  textAlign(CENTER, TOP);
  if (!gameOver) text(countdown, width/2, 8);



  if (!doomsday)
  {
      textSize(16);
    textAlign(RIGHT, TOP);
    text("Rebuild City @ "+ cityPoints +" points.", width-16, 8);
  }
  if (doomsday) {
   
  } 
 
 if (waveTimer < ANNOUNCE_TIME || gameOver  )
  {
  
     bonusString = "\n \n"+score;

    textAlign(CENTER, CENTER);
    textSize(24); 
     text("YOUR SCORE: "+score, width/2+75, height/2+110);
   if (score >= highscore) {
     highscore = score;
   }
   text("HIGH SCORE: "+highscore, width/2+75, height/2+145);
  
       
  
  }
  //////////////////////
  if (paused)
  {
   
    if (NewCitybadge == true) {

      image(NewCityBadge, 0, 0);
    }
   
    if (flawlessbadge == true) {
      image(FlawlessBadge, 0, 0);
      newcity.start();
    }
    if ( doomsdaybadge == true) {

      image( DoomsdamBadge, 0, 0);
      newcity.start();
    }
    /////////////////////
  }
 
}

public int blastColor()
{
  int phase = drawingFrame % 4;
  return color(255, 255*(phase/2), 255*(phase%2));
}

public void drawPlayer()
{
  fill(255);
  noStroke();

  if (bounce == false) {
    image(satelitedeflect, playerX - playerWidth/2-15, playerY-25);
  }

  if (bounce == true ) {
    image(satelite, playerX - playerWidth/2, playerY);
  }
}

public void drawMissiles()
{
  Iterator i = missiles.iterator();
  while (i.hasNext ())
  {
    Missile m = (Missile) i.next();
    m.draw();
  }
}

public void drawCities()
{
  noStroke();
 

  if (!doomsday)
  {
    image(backgroundruins, 0, 0);
   
    drawPlayer();
   
    
    if ( gameOver) {

      if (flawlessbadge == true) {
        image(FlawlessBadge, 0, 0);
      }
      if ( doomsdaybadge == true ) {

        image( DoomsdamBadge, 0, 300);
      }
      image(FlawlessBadge, 0, 0);
      image(ScoreBadge, 0, 0-100);
    }
  }
  if (doomsday) {
    image(backgroundruinsightmare, 0, 0);
      drawPlayer();
    
     
    if ( gameOver ) {
      image( DoomsdamBadge, 0, 0);
        image(ScoreBadge, 0, 0-100);
    }
  } 

  if ( nightmare = true) {
    }
  if (nightmare = false) {
     }
  for (int i = 0; i < NUM_CITIES; i++)
    if (cities[i])
    {
      strokeWeight(1);
      fill(0, 0, 255);
      stroke(0, 255, 255);
      ellipse(cityPos(i), height+100, CITY_RADIUS*2, CITY_RADIUS*2);

      if (i == 0) {
        image(building1, 0, 0);
       
      }
      if (i == 1) {
        image(building2, 0, 0);
      
      }
      if (i == 2) {
        image(building3, 0, 0);
      
      }
      if (i == 3) {
        image(building4, 0, 0);
      
      }
      if (i == 4) {
        image(building5, 0, 0);
      
      }
      if (i == 5) {
        image(building6, 0, 0);
        
      }

       image(homescreen,0,0);

    }
}

//////////  STATE MANAGEMENT

public void spawnInvaders()
{
  int strength = 0;
  int level = difficulty - START_DIFFICULTY;
  for (int r = 0; r < INVADER_BLOCK_HEIGHT; r++)
  {
    if (r == 0) strength = (level)/2+2;
    if (r == 1) strength = (level+1)/2+1;
    if (r == 2) strength = (level)/2+1;
    if (r == 3) strength = (level+1)/2;
    if (r == 4) strength = (level+1)/2-1;
    if (doomsday) strength = 7;
    for (int c = 0; c < INVADER_BLOCK_WIDTH; c++)
    {
      invaders.add(new Invader(c, r+1, strength));
    }
  }
}

public void rebuildCity()
{
  for (int i = 0; i < cities.length; i++)
  {
    hitscounter = hitscounter - NUM_CITIES; 
    if (hitscounter < 0) {
      hitscounter = 0; 
    }
    if (!cities[i])
    {
      cities[i] = true;
      NewCitybadge = true; 
      if (NewCitybadge == true) {
        pause(); 
        
      }
     
    }
  }
}

public void nextLevel()
{
  difficulty++;
  
  shotTimer = SHOT_DELAY_BASE / difficulty;
  int citiesRemaining = 0;
  for (int i=0; i < NUM_CITIES; i++) if (cities[i]) ++citiesRemaining;
   
  if (doomsday && !firstLevel) {
    announceString = "DOOMSDAY ACHIEVEMENT AWARDED \n WAVE "+(difficulty - START_DIFFICULTY + 1);
    doomsdaybadge = true;
    pause();

   
  } 
  if (!firstLevel)
  {
    bonusString += "\n- BONUS -\n";
    bonusString +="CITIES  "+citiesRemaining+" x "+CITY_BONUS+"\n";
    score += (citiesRemaining * CITY_BONUS);
    
    if (score == cityPoints) {
      NewCitybadge = true; 
      pause();
    }
    if (!firstLevel && score >=cityPoints && !doomsday &&gameOver) {


      bonusString +="FLAWLESS DEFENSE /n ACHIEVEMENT AWARDED  ";
      score = score + 5000;
      flawlessbadge = true; 
      pause();
    }
    int waveSecs = waveTimer / PHYS_FPS;
    if (waveSecs < TIME_BONUS_SECS)
    {
      bonusString += "TIME  "+(TIME_BONUS_SECS - waveSecs)+" x "+TIME_BONUS+"\n";
      score += (TIME_BONUS_SECS - waveSecs)* TIME_BONUS;
     
    }

    while (citiesRemaining < NUM_CITIES && score >= cityPoints && !doomsday)
    {
      bonusString += cityPoints+" POINTS - CITY REBUILT\n";
      cityPoints += EXTRA_CITY_AT;
     
      rebuildCity();
    }
  }
  citiesRemaining = 0;

  for (int i=0; i < NUM_CITIES; i++) if (cities[i]) ++citiesRemaining;
  if (citiesRemaining == 0 )
  {
    gameOver = true;
   

    if (doomsdaybadge == true) {
      image( DoomsdamBadge, 0, 300);
    }
    if (flawlessbadge == true) {
      image(FlawlessBadge, 0, 0);
    }
   
    image(ScoreBadge, 0, 0);

    bonusString += "\n \n"+cityPoints;
    bonusString += "\n \n"+score;
  }

  waveTimer = 0;
  flawlessDefense = true;
  marchDir = MARCH_RIGHT;
  if ((cities[5])&&!firstLevel) NewCitybadge = true;  
  pause();
  if (!gameOver) spawnInvaders();

  firstLevel = false;
}

public void titleScreen()
{
  ready = false;
  image(titlescreen, 0, 0); 
  doomsdaybadge = false;
  flawlessbadge = false; 
  doomsday = false;
  nightmare = false; 
  hitscounter = 0; 
//
  text(score, width/2+75, height);

  atTitle = true;
  end.pause(); 
  end.seekTo(0);
  end.setLooping(false);
   track1.pause();
       track1.seekTo(0);
      track2.pause();
      track2.seekTo(0);
      track3.pause();
      track3.seekTo(0);
      track4.pause();
      track4.seekTo(0);
      track5.pause();
      track5.seekTo(0);
      track6.pause();
      track6.seekTo(0);
      track7.pause();
      track7.seekTo(0);
      track8.pause();
      track8.seekTo(0);

  intro.pause();
  intro.seekTo(0); 
  intro.start(); 
  intro.setLooping(true);
 // intro.setLooping(true); 
  
}

public void newGame()
{
  textSize(16);
  text("LOADING", width/2, 50); 
  
  hitscounter = 0; 
  intro.pause();
  intro.seekTo(0);
  intro.setLooping(false);
  button.start();
 // button.setLooping(true); 
  
  int sl = (int)random(1, 8);
   if (sl == 1 ){
    track1.pause();
    track1.seekTo(0);
     track1.start();
     
     track1.setLooping(true);
   }
  if (sl == 2 ) {
    track2.pause();
    track2.seekTo(0);
    track2.start();

    track2.setLooping(true);
  }
  if (sl == 3 ) {
    track3.pause();
    track3.seekTo(0);
    track3.start();

    track3.setLooping(true);
  }
  if (sl == 4 ) {
    track4.pause();
    track4.seekTo(0);
    track4.start();

    track4.setLooping(true);
  }
  if (sl == 5 ) {
    track5.pause();
    track5.seekTo(0);
    track5.start();

    track5.setLooping(true);
  }
  if (sl == 6 ) {
    track6.pause();
    track6.seekTo(0);
    track6.start();

    track6.setLooping(true);
  }
  if (sl == 7 ) {
    track7.pause();
    track7.seekTo(0);
    track7.start();

    track7.setLooping(true);
  }
  if (sl == 8 ) {
    track8.pause();
    track8.seekTo(0);
    track8.start();

    track8.setLooping(true);
  }


  missiles = new ArrayList();
  explosions = new ArrayList();
  invaders = new ArrayList();
  patterns = new PVector[7][];
  for (int j = 0; j < patterns.length; j++)
  {
    PVector[] pattern = new PVector[8];
    for (int i = 0; i < pattern.length; i++)
    {
      PVector corner = new PVector((int)random(INVADER_RADIUS), -INVADER_RADIUS+(int)random(INVADER_RADIUS*2));
      pattern[i] = corner;
    }
    patterns[j] = pattern;
  }
  cities = new boolean[NUM_CITIES];
  for (int i = 0; i < NUM_CITIES; i++) cities[i]=true;
  drawingFrame = 0;
  physicsFrame = 0;
  score = 0;
  if (!doomsday) difficulty = START_DIFFICULTY - 1;

  else difficulty = DOOMSDAY_DIFFICULTY -1;

   cityPoints = EXTRA_CITY_AT;
  gameOver = false;
  atTitle = false;
  firstLevel = true;
  nextLevel();
}

public void pause(boolean toPause)
{




  paused = toPause;

}

public void setup()
{
  //p2d 640 640
 
  orientation(PORTRAIT);
  frameRate(60);

 // minim = new Minim(this);
 
  citybutton = loadImage("citybutton.png");

  friendlyrocket = loadImage("friendlyrocket.png");
  infobutton = loadImage("infobutton.png");
  nightmarebutton = loadImage("nightmarebutton.png");
  satelite = loadImage("sat.png");
  satelitedeflect = loadImage("satdef.png");

  backgroundruins = loadImage("background1ruins.png");
  backgroundruinsightmare = loadImage("backgroundruinsnightmare.png"); 
  titlescreen = loadImage("titlescreen.png");
  ratethis = loadImage("feedback.png");
  sharethis = loadImage("ratethis.png");
  homescreen = loadImage("homescreen.png"); 
  building1 = loadImage("building1.png");
  building2 = loadImage("building2.png");
  building3 = loadImage("building3.png");
  building4 = loadImage("building4.png");
  building5 = loadImage("building5.png");
  building6 = loadImage("building6.png"); 
  alien1a = loadImage("alien1a.png"); 
  alien1b = loadImage("alien1b.png"); 
  alien2a = loadImage("alien2a.png"); 
  alien2b = loadImage("alien2b.png"); 
  alien3a = loadImage("alien3a.png"); 
  alien3b = loadImage("alien3b.png"); 
  alien4a = loadImage("alien4a.png"); 
  alien4b = loadImage("alien4b.png"); 

  FlawlessBadge = loadImage("flawlessdefence.png"); 
  DoomsdamBadge = loadImage("doomsdaybonus.png");  
  ScoreBadge = loadImage("Score.png");  
  BonusBadge = loadImage("timebonus.png"); 
  NewCityBadge = loadImage("newcitybadge.png"); 

  intro = new APMediaPlayer(this);
  intro.setMediaFile("intro2.mp3"); 
  end = new APMediaPlayer(this);
  end.setMediaFile("Endgame.mp3"); 
  newcity = new APMediaPlayer(this);
  newcity.setMediaFile("citylevelup.wav");
  button = new APMediaPlayer(this);
  button.setMediaFile("buttonselect.wav");
 deflect = new APMediaPlayer(this);
  deflect.setMediaFile("deflect.wav"); 

  boom1 = new APMediaPlayer(this);
  boom1.setMediaFile("boom1.wav"); 
  boom2 = new APMediaPlayer(this);
  boom2.setMediaFile("boom2.wav"); 
 boom3 = new APMediaPlayer(this);
  boom3.setMediaFile("boom3.wav"); 
  boom4 = new APMediaPlayer(this);
  boom4.setMediaFile("boom4.wav"); 
  boom5 = new APMediaPlayer(this);
  boom5.setMediaFile("boom5.wav"); 
  boom6 = new APMediaPlayer(this);
  boom6.setMediaFile("boom6.wav"); 
  boom7 = new APMediaPlayer(this);
  boom7.setMediaFile("boom7.wav"); 
  boom8 = new APMediaPlayer(this);
  boom8.setMediaFile("boom8.wav"); 
  boom9 = new APMediaPlayer(this);
  boom9.setMediaFile("boom9.wav"); 
  boom10 = new APMediaPlayer(this);
  boom10.setMediaFile("boom10.wav"); 

  laser1 = new APMediaPlayer(this);
  laser1.setMediaFile("laser1.wav"); 
  laser2 = new APMediaPlayer(this);
  laser2.setMediaFile("laser2.wav"); 
  laser3 = new APMediaPlayer(this);
  laser3.setMediaFile("laser2.wav"); 

  track1 = new APMediaPlayer(this);
  track1.setMediaFile("Regtrack1.wav");
  track2 = new APMediaPlayer(this);
  track2.setMediaFile("Regtrack2.mp3");
  track3 = new APMediaPlayer(this);
  track3.setMediaFile("Regtrack3.mp3");
  track4 = new APMediaPlayer(this);
  track4.setMediaFile("Regtrack4.mp3");
  track5 = new APMediaPlayer(this);
  track5.setMediaFile("Regtrack5.mp3");
  track6 = new APMediaPlayer(this);
  track6.setMediaFile("Regtrack6.mp3");
  track7 = new APMediaPlayer(this);
  track7.setMediaFile("Regtrack7.mp3");
  track8= new APMediaPlayer(this);
  track8.setMediaFile("Regtrack8.mp3");

  titleScreen();
}

public void draw()
{
  while (millis () > physMark + PHYS_MILLS)
  {
    if (!paused && !atTitle && !gameOver)physicsStep();
    physMark += PHYS_MILLS;
  }
  if (millis() > drawMark + DRAW_MILLS)
  {
    drawFrame();
    drawMark += DRAW_MILLS;
  }
}

//void stop()
//{

//  super.stop();
//}
public void onDestroy() {

  super.onDestroy(); //call onDestroy on super class
  adView.destroy();
 
if(end!=null) { //must be checked because or else crash when return from landscape mode
    end.release(); //release the player
  }

if(newcity!=null) { //must be checked because or else crash when return from landscape mode
    newcity.release(); //release the player
  }

if(button!=null) { //must be checked because or else crash when return from landscape mode
    button.release(); //release the player
  }

if(deflect!=null) { //must be checked because or else crash when return from landscape mode
    deflect.release(); //release the player
  }

if(intro!=null) { //must be checked because or else crash when return from landscape mode
    intro.release(); //release the player
  }
 
if(boom1!=null) { //must be checked because or else crash when return from landscape mode
    boom1.release(); //release the player
  } 
if(boom2!=null) { //must be checked because or else crash when return from landscape mode
    boom2.release(); //release the player
  } 
if(boom3!=null) { //must be checked because or else crash when return from landscape mode
    boom3.release(); //release the player
  } 
if(boom4!=null) { //must be checked because or else crash when return from landscape mode
    boom4.release(); //release the player
  } 
if(boom5!=null) { //must be checked because or else crash when return from landscape mode
    boom5.release(); //release the player
  } 
if(boom6!=null) { //must be checked because or else crash when return from landscape mode
    boom6.release(); //release the player
  } 
if(boom7!=null) { //must be checked because or else crash when return from landscape mode
   boom7.release(); //release the player
  } 
if(boom8!=null) { //must be checked because or else crash when return from landscape mode
    boom8.release(); //release the player
  }  
if(boom9!=null) { //must be checked because or else crash when return from landscape mode
   boom9.release(); //release the player
  } 
  if(boom10!=null) { //must be checked because or else crash when return from landscape mode
   boom10.release(); //release the player
  }

if(laser1!=null) { //must be checked because or else crash when return from landscape mode
   laser1.release(); //release the player
  }

if(laser2!=null) { //must be checked because or else crash when return from landscape mode
   laser2.release(); //release the player
  }

if(laser3!=null) { //must be checked because or else crash when return from landscape mode
    laser3.release(); //release the player
  }



if(track1!=null) { //must be checked because or else crash when return from landscape mode
    track1.release(); //release the player
  }
if(track2!=null) { //must be checked because or else crash when return from landscape mode
    track2.release(); //release the player
  }
if(track3!=null) { //must be checked because or else crash when return from landscape mode
    track3.release(); //release the player
  }
if(track4!=null) { //must be checked because or else crash when return from landscape mode
    track4.release(); //release the player
  }
if(track5!=null) { //must be checked because or else crash when return from landscape mode
    track5.release(); //release the player
  }
if(track6!=null) { //must be checked because or else crash when return from landscape mode
    track6.release(); //release the player
  }
if(track7!=null) { //must be checked because or else crash when return from landscape mode
    track7.release(); //release the player
  }
if(track8!=null) { //must be checked because or else crash when return from landscape mode
    track8.release(); //release the player
  }

  }


/////////////// DEBUG
public void mousePressed()
{
  if (!atTitle && !gameOver)
  {
    if (paused) pause(false);
    else  detonateMissiles();
  } else if (!atTitle && gameOver)
  {
    titleScreen();
    if (mousePressed && atTitle) {
  	  ready = true;
    }
  }
 
  if (mousePressed && ready == true) {
    if (mouseX>chx-150 && mouseX <chx+260 && mouseY>chy-25 && mouseY <chy+70 && atTitle && ready == true ) {
      {
        doomsday = false;
        nightmare = true; 
        nightmareround = true; 
        newGame();
      }
    }

    if (mouseX>fbx && mouseX <fbx+80 && mouseY>fby && mouseY <fby+120 && atTitle && ready == true) {
      {

        link("https://www.facebook.com/MADXMISSILE");
        ///facebook share
      }
    }


    if (mouseX>shx && mouseX+80 <shx && mouseY>shy && mouseY <shy+120 && atTitle && ready == true) {
      {

        link("https://play.google.com/store/apps/developer?id=SocialLanternMedia");
    	  //link("http://play.google.com/store/apps/details?id=+ PackageName");
        ///googleplay rating
      }
    }


    
      if (mouseX>ttx-190 && mouseX <ttx+340 && mouseY>tty-10 && mouseY <tty+70 && atTitle && ready == true ) {
        {
          doomsday = true;
          nightmare = false; 
          nightmareround = false;
          newGame();
        }
      }
      
      if (mouseX>hmx && mouseX <hmx+160 && mouseY>hmy && mouseY <hmy+40) {
        {
          for (int i = 0; i < cities.length; i++) cities[i] = false;
      invaders.clear();
      missiles.clear();
      explosions.clear();
      gameOver = true;
      doomsday = false;
      nightmare = false; 
      ready = false;
     
      announceString = "GAME OVER";
      bonusString = "\n \n"+score;
      track1.pause();
      track2.pause();
      track3.pause();
      track4.pause();
      track5.pause();
      track6.pause();
      track7.pause();
      track8.pause();

      end.pause(); 
      end.seekTo(0);
      end.start(); 
      end.setLooping(true);
      button.start();
      titleScreen(); 
    }
        }
      
      }
  }
  



public void keyPressed()
{
  if (!atTitle && !gameOver)
  {
    if (key == 'p') pause(true);

    else if (!paused && key == ' ') detonateMissiles();
    else if (key == 'q')

    {
      for (int i = 0; i < cities.length; i++) cities[i] = false;
      invaders.clear();
      missiles.clear();
      explosions.clear();
      gameOver = true;
      doomsday = false;
      nightmare = false; 
     
      announceString = "GAME OVER";
      bonusString = "\n \n"+score;
       track1.pause();
       track1.seekTo(0);
      track2.pause();
      track2.seekTo(0);
      track3.pause();
      track3.seekTo(0);
      track4.pause();
      track4.seekTo(0);
      track5.pause();
      track5.seekTo(0);
      track6.pause();
      track6.seekTo(0);
      track7.pause();
      track7.seekTo(0);
      track8.pause();
      track8.seekTo(0);

      end.start(); 
      end.setLooping(true);
      button.start();
     }
    
 
  
  
  } else if (!atTitle && gameOver)
  {
    titleScreen();
  } else if (atTitle)
  {
    if (key == 'a')
    {
      NewCitybadge = true;
    }
    if (key == 'z') {
      flawlessbadge = true;
      pause();
    }
    if (key == 'x') {
      doomsdaybadge = true; 

      pause();
    }

    if (key == 't')
    {
      doomsday = true;
      nightmare = false; 
      nightmareround = false; 
      newGame();
    }
    if (key == 'd')
    {
      doomsday = false;
      nightmare = true; 
      nightmareround = true;

      newGame();
    }
  }
}


public void mouseReleased() {
	
	adView.loadAd();
}


  public int sketchWidth() { return displayWidth; }
  public int sketchHeight() { return 640; }

//  @Override
  //public String sketchRenderer() {
    //  return P2D;
 // }

}

//Here we provide the necessary cleanup when the app closes
//<a rel="nofollow" href="/two/profile/Override">@Override</a>

