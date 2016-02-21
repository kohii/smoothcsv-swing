/*
 * Copyright 2016 kohii
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.smoothcsv.swing.icon;

/**
 * @author kohii
 * @see http://fortawesome.github.io/Font-Awesome/cheatsheet/
 */
// @formatter:off
// snipet js to extract list:
// $('.row').eq(1).find('i.fa').map(function(i, el){return $(el).parent().contents().filter(function(){return this.nodeType == 3;}).text().trim() + '\t' + ($(el).next().text().indexOf('alias')>=0?$(el).next().next().text():$(el).next().text());}).get().join('\n');
// @formatter:on
public interface AwesomeIconConstants {
  char FA_500PX = '\uf26e';
  char FA_ADJUST = '\uf042';
  char FA_ADN = '\uf170';
  char FA_ALIGN_CENTER = '\uf037';
  char FA_ALIGN_JUSTIFY = '\uf039';
  char FA_ALIGN_LEFT = '\uf036';
  char FA_ALIGN_RIGHT = '\uf038';
  char FA_AMAZON = '\uf270';
  char FA_AMBULANCE = '\uf0f9';
  char FA_ANCHOR = '\uf13d';
  char FA_ANDROID = '\uf17b';
  char FA_ANGELLIST = '\uf209';
  char FA_ANGLE_DOUBLE_DOWN = '\uf103';
  char FA_ANGLE_DOUBLE_LEFT = '\uf100';
  char FA_ANGLE_DOUBLE_RIGHT = '\uf101';
  char FA_ANGLE_DOUBLE_UP = '\uf102';
  char FA_ANGLE_DOWN = '\uf107';
  char FA_ANGLE_LEFT = '\uf104';
  char FA_ANGLE_RIGHT = '\uf105';
  char FA_ANGLE_UP = '\uf106';
  char FA_APPLE = '\uf179';
  char FA_ARCHIVE = '\uf187';
  char FA_AREA_CHART = '\uf1fe';
  char FA_ARROW_CIRCLE_DOWN = '\uf0ab';
  char FA_ARROW_CIRCLE_LEFT = '\uf0a8';
  char FA_ARROW_CIRCLE_O_DOWN = '\uf01a';
  char FA_ARROW_CIRCLE_O_LEFT = '\uf190';
  char FA_ARROW_CIRCLE_O_RIGHT = '\uf18e';
  char FA_ARROW_CIRCLE_O_UP = '\uf01b';
  char FA_ARROW_CIRCLE_RIGHT = '\uf0a9';
  char FA_ARROW_CIRCLE_UP = '\uf0aa';
  char FA_ARROW_DOWN = '\uf063';
  char FA_ARROW_LEFT = '\uf060';
  char FA_ARROW_RIGHT = '\uf061';
  char FA_ARROW_UP = '\uf062';
  char FA_ARROWS = '\uf047';
  char FA_ARROWS_ALT = '\uf0b2';
  char FA_ARROWS_H = '\uf07e';
  char FA_ARROWS_V = '\uf07d';
  char FA_ASTERISK = '\uf069';
  char FA_AT = '\uf1fa';
  char FA_AUTOMOBILE = '\uf1b9';
  char FA_BACKWARD = '\uf04a';
  char FA_BALANCE_SCALE = '\uf24e';
  char FA_BAN = '\uf05e';
  char FA_BANK = '\uf19c';
  char FA_BAR_CHART = '\uf080';
  char FA_BAR_CHART_O = '\uf080';
  char FA_BARCODE = '\uf02a';
  char FA_BARS = '\uf0c9';
  char FA_BATTERY_0 = '\uf244';
  char FA_BATTERY_1 = '\uf243';
  char FA_BATTERY_2 = '\uf242';
  char FA_BATTERY_3 = '\uf241';
  char FA_BATTERY_4 = '\uf240';
  char FA_BATTERY_EMPTY = '\uf244';
  char FA_BATTERY_FULL = '\uf240';
  char FA_BATTERY_HALF = '\uf242';
  char FA_BATTERY_QUARTER = '\uf243';
  char FA_BATTERY_THREE_QUARTERS = '\uf241';
  char FA_BED = '\uf236';
  char FA_BEER = '\uf0fc';
  char FA_BEHANCE = '\uf1b4';
  char FA_BEHANCE_SQUARE = '\uf1b5';
  char FA_BELL = '\uf0f3';
  char FA_BELL_O = '\uf0a2';
  char FA_BELL_SLASH = '\uf1f6';
  char FA_BELL_SLASH_O = '\uf1f7';
  char FA_BICYCLE = '\uf206';
  char FA_BINOCULARS = '\uf1e5';
  char FA_BIRTHDAY_CAKE = '\uf1fd';
  char FA_BITBUCKET = '\uf171';
  char FA_BITBUCKET_SQUARE = '\uf172';
  char FA_BITCOIN = '\uf15a';
  char FA_BLACK_TIE = '\uf27e';
  char FA_BOLD = '\uf032';
  char FA_BOLT = '\uf0e7';
  char FA_BOMB = '\uf1e2';
  char FA_BOOK = '\uf02d';
  char FA_BOOKMARK = '\uf02e';
  char FA_BOOKMARK_O = '\uf097';
  char FA_BRIEFCASE = '\uf0b1';
  char FA_BTC = '\uf15a';
  char FA_BUG = '\uf188';
  char FA_BUILDING = '\uf1ad';
  char FA_BUILDING_O = '\uf0f7';
  char FA_BULLHORN = '\uf0a1';
  char FA_BULLSEYE = '\uf140';
  char FA_BUS = '\uf207';
  char FA_BUYSELLADS = '\uf20d';
  char FA_CAB = '\uf1ba';
  char FA_CALCULATOR = '\uf1ec';
  char FA_CALENDAR = '\uf073';
  char FA_CALENDAR_CHECK_O = '\uf274';
  char FA_CALENDAR_MINUS_O = '\uf272';
  char FA_CALENDAR_O = '\uf133';
  char FA_CALENDAR_PLUS_O = '\uf271';
  char FA_CALENDAR_TIMES_O = '\uf273';
  char FA_CAMERA = '\uf030';
  char FA_CAMERA_RETRO = '\uf083';
  char FA_CAR = '\uf1b9';
  char FA_CARET_DOWN = '\uf0d7';
  char FA_CARET_LEFT = '\uf0d9';
  char FA_CARET_RIGHT = '\uf0da';
  char FA_CARET_SQUARE_O_DOWN = '\uf150';
  char FA_CARET_SQUARE_O_LEFT = '\uf191';
  char FA_CARET_SQUARE_O_RIGHT = '\uf152';
  char FA_CARET_SQUARE_O_UP = '\uf151';
  char FA_CARET_UP = '\uf0d8';
  char FA_CART_ARROW_DOWN = '\uf218';
  char FA_CART_PLUS = '\uf217';
  char FA_CC = '\uf20a';
  char FA_CC_AMEX = '\uf1f3';
  char FA_CC_DINERS_CLUB = '\uf24c';
  char FA_CC_DISCOVER = '\uf1f2';
  char FA_CC_JCB = '\uf24b';
  char FA_CC_MASTERCARD = '\uf1f1';
  char FA_CC_PAYPAL = '\uf1f4';
  char FA_CC_STRIPE = '\uf1f5';
  char FA_CC_VISA = '\uf1f0';
  char FA_CERTIFICATE = '\uf0a3';
  char FA_CHAIN = '\uf0c1';
  char FA_CHAIN_BROKEN = '\uf127';
  char FA_CHECK = '\uf00c';
  char FA_CHECK_CIRCLE = '\uf058';
  char FA_CHECK_CIRCLE_O = '\uf05d';
  char FA_CHECK_SQUARE = '\uf14a';
  char FA_CHECK_SQUARE_O = '\uf046';
  char FA_CHEVRON_CIRCLE_DOWN = '\uf13a';
  char FA_CHEVRON_CIRCLE_LEFT = '\uf137';
  char FA_CHEVRON_CIRCLE_RIGHT = '\uf138';
  char FA_CHEVRON_CIRCLE_UP = '\uf139';
  char FA_CHEVRON_DOWN = '\uf078';
  char FA_CHEVRON_LEFT = '\uf053';
  char FA_CHEVRON_RIGHT = '\uf054';
  char FA_CHEVRON_UP = '\uf077';
  char FA_CHILD = '\uf1ae';
  char FA_CHROME = '\uf268';
  char FA_CIRCLE = '\uf111';
  char FA_CIRCLE_O = '\uf10c';
  char FA_CIRCLE_O_NOTCH = '\uf1ce';
  char FA_CIRCLE_THIN = '\uf1db';
  char FA_CLIPBOARD = '\uf0ea';
  char FA_CLOCK_O = '\uf017';
  char FA_CLONE = '\uf24d';
  char FA_CLOSE = '\uf00d';
  char FA_CLOUD = '\uf0c2';
  char FA_CLOUD_DOWNLOAD = '\uf0ed';
  char FA_CLOUD_UPLOAD = '\uf0ee';
  char FA_CNY = '\uf157';
  char FA_CODE = '\uf121';
  char FA_CODE_FORK = '\uf126';
  char FA_CODEPEN = '\uf1cb';
  char FA_COFFEE = '\uf0f4';
  char FA_COG = '\uf013';
  char FA_COGS = '\uf085';
  char FA_COLUMNS = '\uf0db';
  char FA_COMMENT = '\uf075';
  char FA_COMMENT_O = '\uf0e5';
  char FA_COMMENTING = '\uf27a';
  char FA_COMMENTING_O = '\uf27b';
  char FA_COMMENTS = '\uf086';
  char FA_COMMENTS_O = '\uf0e6';
  char FA_COMPASS = '\uf14e';
  char FA_COMPRESS = '\uf066';
  char FA_CONNECTDEVELOP = '\uf20e';
  char FA_CONTAO = '\uf26d';
  char FA_COPY = '\uf0c5';
  char FA_COPYRIGHT = '\uf1f9';
  char FA_CREATIVE_COMMONS = '\uf25e';
  char FA_CREDIT_CARD = '\uf09d';
  char FA_CROP = '\uf125';
  char FA_CROSSHAIRS = '\uf05b';
  char FA_CSS3 = '\uf13c';
  char FA_CUBE = '\uf1b2';
  char FA_CUBES = '\uf1b3';
  char FA_CUT = '\uf0c4';
  char FA_CUTLERY = '\uf0f5';
  char FA_DASHBOARD = '\uf0e4';
  char FA_DASHCUBE = '\uf210';
  char FA_DATABASE = '\uf1c0';
  char FA_DEDENT = '\uf03b';
  char FA_DELICIOUS = '\uf1a5';
  char FA_DESKTOP = '\uf108';
  char FA_DEVIANTART = '\uf1bd';
  char FA_DIAMOND = '\uf219';
  char FA_DIGG = '\uf1a6';
  char FA_DOLLAR = '\uf155';
  char FA_DOT_CIRCLE_O = '\uf192';
  char FA_DOWNLOAD = '\uf019';
  char FA_DRIBBBLE = '\uf17d';
  char FA_DROPBOX = '\uf16b';
  char FA_DRUPAL = '\uf1a9';
  char FA_EDIT = '\uf044';
  char FA_EJECT = '\uf052';
  char FA_ELLIPSIS_H = '\uf141';
  char FA_ELLIPSIS_V = '\uf142';
  char FA_EMPIRE = '\uf1d1';
  char FA_ENVELOPE = '\uf0e0';
  char FA_ENVELOPE_O = '\uf003';
  char FA_ENVELOPE_SQUARE = '\uf199';
  char FA_ERASER = '\uf12d';
  char FA_EUR = '\uf153';
  char FA_EURO = '\uf153';
  char FA_EXCHANGE = '\uf0ec';
  char FA_EXCLAMATION = '\uf12a';
  char FA_EXCLAMATION_CIRCLE = '\uf06a';
  char FA_EXCLAMATION_TRIANGLE = '\uf071';
  char FA_EXPAND = '\uf065';
  char FA_EXPEDITEDSSL = '\uf23e';
  char FA_EXTERNAL_LINK = '\uf08e';
  char FA_EXTERNAL_LINK_SQUARE = '\uf14c';
  char FA_EYE = '\uf06e';
  char FA_EYE_SLASH = '\uf070';
  char FA_EYEDROPPER = '\uf1fb';
  char FA_FACEBOOK = '\uf09a';
  char FA_FACEBOOK_F = '\uf09a';
  char FA_FACEBOOK_OFFICIAL = '\uf230';
  char FA_FACEBOOK_SQUARE = '\uf082';
  char FA_FAST_BACKWARD = '\uf049';
  char FA_FAST_FORWARD = '\uf050';
  char FA_FAX = '\uf1ac';
  char FA_FEED = '\uf09e';
  char FA_FEMALE = '\uf182';
  char FA_FIGHTER_JET = '\uf0fb';
  char FA_FILE = '\uf15b';
  char FA_FILE_ARCHIVE_O = '\uf1c6';
  char FA_FILE_AUDIO_O = '\uf1c7';
  char FA_FILE_CODE_O = '\uf1c9';
  char FA_FILE_EXCEL_O = '\uf1c3';
  char FA_FILE_IMAGE_O = '\uf1c5';
  char FA_FILE_MOVIE_O = '\uf1c8';
  char FA_FILE_O = '\uf016';
  char FA_FILE_PDF_O = '\uf1c1';
  char FA_FILE_PHOTO_O = '\uf1c5';
  char FA_FILE_PICTURE_O = '\uf1c5';
  char FA_FILE_POWERPOINT_O = '\uf1c4';
  char FA_FILE_SOUND_O = '\uf1c7';
  char FA_FILE_TEXT = '\uf15c';
  char FA_FILE_TEXT_O = '\uf0f6';
  char FA_FILE_VIDEO_O = '\uf1c8';
  char FA_FILE_WORD_O = '\uf1c2';
  char FA_FILE_ZIP_O = '\uf1c6';
  char FA_FILES_O = '\uf0c5';
  char FA_FILM = '\uf008';
  char FA_FILTER = '\uf0b0';
  char FA_FIRE = '\uf06d';
  char FA_FIRE_EXTINGUISHER = '\uf134';
  char FA_FIREFOX = '\uf269';
  char FA_FLAG = '\uf024';
  char FA_FLAG_CHECKERED = '\uf11e';
  char FA_FLAG_O = '\uf11d';
  char FA_FLASH = '\uf0e7';
  char FA_FLASK = '\uf0c3';
  char FA_FLICKR = '\uf16e';
  char FA_FLOPPY_O = '\uf0c7';
  char FA_FOLDER = '\uf07b';
  char FA_FOLDER_O = '\uf114';
  char FA_FOLDER_OPEN = '\uf07c';
  char FA_FOLDER_OPEN_O = '\uf115';
  char FA_FONT = '\uf031';
  char FA_FONTICONS = '\uf280';
  char FA_FORUMBEE = '\uf211';
  char FA_FORWARD = '\uf04e';
  char FA_FOURSQUARE = '\uf180';
  char FA_FROWN_O = '\uf119';
  char FA_FUTBOL_O = '\uf1e3';
  char FA_GAMEPAD = '\uf11b';
  char FA_GAVEL = '\uf0e3';
  char FA_GBP = '\uf154';
  char FA_GE = '\uf1d1';
  char FA_GEAR = '\uf013';
  char FA_GEARS = '\uf085';
  char FA_GENDERLESS = '\uf22d';
  char FA_GET_POCKET = '\uf265';
  char FA_GG = '\uf260';
  char FA_GG_CIRCLE = '\uf261';
  char FA_GIFT = '\uf06b';
  char FA_GIT = '\uf1d3';
  char FA_GIT_SQUARE = '\uf1d2';
  char FA_GITHUB = '\uf09b';
  char FA_GITHUB_ALT = '\uf113';
  char FA_GITHUB_SQUARE = '\uf092';
  char FA_GITTIP = '\uf184';
  char FA_GLASS = '\uf000';
  char FA_GLOBE = '\uf0ac';
  char FA_GOOGLE = '\uf1a0';
  char FA_GOOGLE_PLUS = '\uf0d5';
  char FA_GOOGLE_PLUS_SQUARE = '\uf0d4';
  char FA_GOOGLE_WALLET = '\uf1ee';
  char FA_GRADUATION_CAP = '\uf19d';
  char FA_GRATIPAY = '\uf184';
  char FA_GROUP = '\uf0c0';
  char FA_H_SQUARE = '\uf0fd';
  char FA_HACKER_NEWS = '\uf1d4';
  char FA_HAND_GRAB_O = '\uf255';
  char FA_HAND_LIZARD_O = '\uf258';
  char FA_HAND_O_DOWN = '\uf0a7';
  char FA_HAND_O_LEFT = '\uf0a5';
  char FA_HAND_O_RIGHT = '\uf0a4';
  char FA_HAND_O_UP = '\uf0a6';
  char FA_HAND_PAPER_O = '\uf256';
  char FA_HAND_PEACE_O = '\uf25b';
  char FA_HAND_POINTER_O = '\uf25a';
  char FA_HAND_ROCK_O = '\uf255';
  char FA_HAND_SCISSORS_O = '\uf257';
  char FA_HAND_SPOCK_O = '\uf259';
  char FA_HAND_STOP_O = '\uf256';
  char FA_HDD_O = '\uf0a0';
  char FA_HEADER = '\uf1dc';
  char FA_HEADPHONES = '\uf025';
  char FA_HEART = '\uf004';
  char FA_HEART_O = '\uf08a';
  char FA_HEARTBEAT = '\uf21e';
  char FA_HISTORY = '\uf1da';
  char FA_HOME = '\uf015';
  char FA_HOSPITAL_O = '\uf0f8';
  char FA_HOTEL = '\uf236';
  char FA_HOURGLASS = '\uf254';
  char FA_HOURGLASS_1 = '\uf251';
  char FA_HOURGLASS_2 = '\uf252';
  char FA_HOURGLASS_3 = '\uf253';
  char FA_HOURGLASS_END = '\uf253';
  char FA_HOURGLASS_HALF = '\uf252';
  char FA_HOURGLASS_O = '\uf250';
  char FA_HOURGLASS_START = '\uf251';
  char FA_HOUZZ = '\uf27c';
  char FA_HTML5 = '\uf13b';
  char FA_I_CURSOR = '\uf246';
  char FA_ILS = '\uf20b';
  char FA_IMAGE = '\uf03e';
  char FA_INBOX = '\uf01c';
  char FA_INDENT = '\uf03c';
  char FA_INDUSTRY = '\uf275';
  char FA_INFO = '\uf129';
  char FA_INFO_CIRCLE = '\uf05a';
  char FA_INR = '\uf156';
  char FA_INSTAGRAM = '\uf16d';
  char FA_INSTITUTION = '\uf19c';
  char FA_INTERNET_EXPLORER = '\uf26b';
  char FA_INTERSEX = '\uf224';
  char FA_IOXHOST = '\uf208';
  char FA_ITALIC = '\uf033';
  char FA_JOOMLA = '\uf1aa';
  char FA_JPY = '\uf157';
  char FA_JSFIDDLE = '\uf1cc';
  char FA_KEY = '\uf084';
  char FA_KEYBOARD_O = '\uf11c';
  char FA_KRW = '\uf159';
  char FA_LANGUAGE = '\uf1ab';
  char FA_LAPTOP = '\uf109';
  char FA_LASTFM = '\uf202';
  char FA_LASTFM_SQUARE = '\uf203';
  char FA_LEAF = '\uf06c';
  char FA_LEANPUB = '\uf212';
  char FA_LEGAL = '\uf0e3';
  char FA_LEMON_O = '\uf094';
  char FA_LEVEL_DOWN = '\uf149';
  char FA_LEVEL_UP = '\uf148';
  char FA_LIFE_BOUY = '\uf1cd';
  char FA_LIFE_BUOY = '\uf1cd';
  char FA_LIFE_RING = '\uf1cd';
  char FA_LIFE_SAVER = '\uf1cd';
  char FA_LIGHTBULB_O = '\uf0eb';
  char FA_LINE_CHART = '\uf201';
  char FA_LINK = '\uf0c1';
  char FA_LINKEDIN = '\uf0e1';
  char FA_LINKEDIN_SQUARE = '\uf08c';
  char FA_LINUX = '\uf17c';
  char FA_LIST = '\uf03a';
  char FA_LIST_ALT = '\uf022';
  char FA_LIST_OL = '\uf0cb';
  char FA_LIST_UL = '\uf0ca';
  char FA_LOCATION_ARROW = '\uf124';
  char FA_LOCK = '\uf023';
  char FA_LONG_ARROW_DOWN = '\uf175';
  char FA_LONG_ARROW_LEFT = '\uf177';
  char FA_LONG_ARROW_RIGHT = '\uf178';
  char FA_LONG_ARROW_UP = '\uf176';
  char FA_MAGIC = '\uf0d0';
  char FA_MAGNET = '\uf076';
  char FA_MAIL_FORWARD = '\uf064';
  char FA_MAIL_REPLY = '\uf112';
  char FA_MAIL_REPLY_ALL = '\uf122';
  char FA_MALE = '\uf183';
  char FA_MAP = '\uf279';
  char FA_MAP_MARKER = '\uf041';
  char FA_MAP_O = '\uf278';
  char FA_MAP_PIN = '\uf276';
  char FA_MAP_SIGNS = '\uf277';
  char FA_MARS = '\uf222';
  char FA_MARS_DOUBLE = '\uf227';
  char FA_MARS_STROKE = '\uf229';
  char FA_MARS_STROKE_H = '\uf22b';
  char FA_MARS_STROKE_V = '\uf22a';
  char FA_MAXCDN = '\uf136';
  char FA_MEANPATH = '\uf20c';
  char FA_MEDIUM = '\uf23a';
  char FA_MEDKIT = '\uf0fa';
  char FA_MEH_O = '\uf11a';
  char FA_MERCURY = '\uf223';
  char FA_MICROPHONE = '\uf130';
  char FA_MICROPHONE_SLASH = '\uf131';
  char FA_MINUS = '\uf068';
  char FA_MINUS_CIRCLE = '\uf056';
  char FA_MINUS_SQUARE = '\uf146';
  char FA_MINUS_SQUARE_O = '\uf147';
  char FA_MOBILE = '\uf10b';
  char FA_MOBILE_PHONE = '\uf10b';
  char FA_MONEY = '\uf0d6';
  char FA_MOON_O = '\uf186';
  char FA_MORTAR_BOARD = '\uf19d';
  char FA_MOTORCYCLE = '\uf21c';
  char FA_MOUSE_POINTER = '\uf245';
  char FA_MUSIC = '\uf001';
  char FA_NAVICON = '\uf0c9';
  char FA_NEUTER = '\uf22c';
  char FA_NEWSPAPER_O = '\uf1ea';
  char FA_OBJECT_GROUP = '\uf247';
  char FA_OBJECT_UNGROUP = '\uf248';
  char FA_ODNOKLASSNIKI = '\uf263';
  char FA_ODNOKLASSNIKI_SQUARE = '\uf264';
  char FA_OPENCART = '\uf23d';
  char FA_OPENID = '\uf19b';
  char FA_OPERA = '\uf26a';
  char FA_OPTIN_MONSTER = '\uf23c';
  char FA_OUTDENT = '\uf03b';
  char FA_PAGELINES = '\uf18c';
  char FA_PAINT_BRUSH = '\uf1fc';
  char FA_PAPER_PLANE = '\uf1d8';
  char FA_PAPER_PLANE_O = '\uf1d9';
  char FA_PAPERCLIP = '\uf0c6';
  char FA_PARAGRAPH = '\uf1dd';
  char FA_PASTE = '\uf0ea';
  char FA_PAUSE = '\uf04c';
  char FA_PAW = '\uf1b0';
  char FA_PAYPAL = '\uf1ed';
  char FA_PENCIL = '\uf040';
  char FA_PENCIL_SQUARE = '\uf14b';
  char FA_PENCIL_SQUARE_O = '\uf044';
  char FA_PHONE = '\uf095';
  char FA_PHONE_SQUARE = '\uf098';
  char FA_PHOTO = '\uf03e';
  char FA_PICTURE_O = '\uf03e';
  char FA_PIE_CHART = '\uf200';
  char FA_PIED_PIPER = '\uf1a7';
  char FA_PIED_PIPER_ALT = '\uf1a8';
  char FA_PINTEREST = '\uf0d2';
  char FA_PINTEREST_P = '\uf231';
  char FA_PINTEREST_SQUARE = '\uf0d3';
  char FA_PLANE = '\uf072';
  char FA_PLAY = '\uf04b';
  char FA_PLAY_CIRCLE = '\uf144';
  char FA_PLAY_CIRCLE_O = '\uf01d';
  char FA_PLUG = '\uf1e6';
  char FA_PLUS = '\uf067';
  char FA_PLUS_CIRCLE = '\uf055';
  char FA_PLUS_SQUARE = '\uf0fe';
  char FA_PLUS_SQUARE_O = '\uf196';
  char FA_POWER_OFF = '\uf011';
  char FA_PRINT = '\uf02f';
  char FA_PUZZLE_PIECE = '\uf12e';
  char FA_QQ = '\uf1d6';
  char FA_QRCODE = '\uf029';
  char FA_QUESTION = '\uf128';
  char FA_QUESTION_CIRCLE = '\uf059';
  char FA_QUOTE_LEFT = '\uf10d';
  char FA_QUOTE_RIGHT = '\uf10e';
  char FA_RA = '\uf1d0';
  char FA_RANDOM = '\uf074';
  char FA_REBEL = '\uf1d0';
  char FA_RECYCLE = '\uf1b8';
  char FA_REDDIT = '\uf1a1';
  char FA_REDDIT_SQUARE = '\uf1a2';
  char FA_REFRESH = '\uf021';
  char FA_REGISTERED = '\uf25d';
  char FA_REMOVE = '\uf00d';
  char FA_RENREN = '\uf18b';
  char FA_REORDER = '\uf0c9';
  char FA_REPEAT = '\uf01e';
  char FA_REPLY = '\uf112';
  char FA_REPLY_ALL = '\uf122';
  char FA_RETWEET = '\uf079';
  char FA_RMB = '\uf157';
  char FA_ROAD = '\uf018';
  char FA_ROCKET = '\uf135';
  char FA_ROTATE_LEFT = '\uf0e2';
  char FA_ROTATE_RIGHT = '\uf01e';
  char FA_ROUBLE = '\uf158';
  char FA_RSS = '\uf09e';
  char FA_RSS_SQUARE = '\uf143';
  char FA_RUB = '\uf158';
  char FA_RUBLE = '\uf158';
  char FA_RUPEE = '\uf156';
  char FA_SAFARI = '\uf267';
  char FA_SAVE = '\uf0c7';
  char FA_SCISSORS = '\uf0c4';
  char FA_SEARCH = '\uf002';
  char FA_SEARCH_MINUS = '\uf010';
  char FA_SEARCH_PLUS = '\uf00e';
  char FA_SELLSY = '\uf213';
  char FA_SEND = '\uf1d8';
  char FA_SEND_O = '\uf1d9';
  char FA_SERVER = '\uf233';
  char FA_SHARE = '\uf064';
  char FA_SHARE_ALT = '\uf1e0';
  char FA_SHARE_ALT_SQUARE = '\uf1e1';
  char FA_SHARE_SQUARE = '\uf14d';
  char FA_SHARE_SQUARE_O = '\uf045';
  char FA_SHEKEL = '\uf20b';
  char FA_SHEQEL = '\uf20b';
  char FA_SHIELD = '\uf132';
  char FA_SHIP = '\uf21a';
  char FA_SHIRTSINBULK = '\uf214';
  char FA_SHOPPING_CART = '\uf07a';
  char FA_SIGN_IN = '\uf090';
  char FA_SIGN_OUT = '\uf08b';
  char FA_SIGNAL = '\uf012';
  char FA_SIMPLYBUILT = '\uf215';
  char FA_SITEMAP = '\uf0e8';
  char FA_SKYATLAS = '\uf216';
  char FA_SKYPE = '\uf17e';
  char FA_SLACK = '\uf198';
  char FA_SLIDERS = '\uf1de';
  char FA_SLIDESHARE = '\uf1e7';
  char FA_SMILE_O = '\uf118';
  char FA_SOCCER_BALL_O = '\uf1e3';
  char FA_SORT = '\uf0dc';
  char FA_SORT_ALPHA_ASC = '\uf15d';
  char FA_SORT_ALPHA_DESC = '\uf15e';
  char FA_SORT_AMOUNT_ASC = '\uf160';
  char FA_SORT_AMOUNT_DESC = '\uf161';
  char FA_SORT_ASC = '\uf0de';
  char FA_SORT_DESC = '\uf0dd';
  char FA_SORT_DOWN = '\uf0dd';
  char FA_SORT_NUMERIC_ASC = '\uf162';
  char FA_SORT_NUMERIC_DESC = '\uf163';
  char FA_SORT_UP = '\uf0de';
  char FA_SOUNDCLOUD = '\uf1be';
  char FA_SPACE_SHUTTLE = '\uf197';
  char FA_SPINNER = '\uf110';
  char FA_SPOON = '\uf1b1';
  char FA_SPOTIFY = '\uf1bc';
  char FA_SQUARE = '\uf0c8';
  char FA_SQUARE_O = '\uf096';
  char FA_STACK_EXCHANGE = '\uf18d';
  char FA_STACK_OVERFLOW = '\uf16c';
  char FA_STAR = '\uf005';
  char FA_STAR_HALF = '\uf089';
  char FA_STAR_HALF_EMPTY = '\uf123';
  char FA_STAR_HALF_FULL = '\uf123';
  char FA_STAR_HALF_O = '\uf123';
  char FA_STAR_O = '\uf006';
  char FA_STEAM = '\uf1b6';
  char FA_STEAM_SQUARE = '\uf1b7';
  char FA_STEP_BACKWARD = '\uf048';
  char FA_STEP_FORWARD = '\uf051';
  char FA_STETHOSCOPE = '\uf0f1';
  char FA_STICKY_NOTE = '\uf249';
  char FA_STICKY_NOTE_O = '\uf24a';
  char FA_STOP = '\uf04d';
  char FA_STREET_VIEW = '\uf21d';
  char FA_STRIKETHROUGH = '\uf0cc';
  char FA_STUMBLEUPON = '\uf1a4';
  char FA_STUMBLEUPON_CIRCLE = '\uf1a3';
  char FA_SUBSCRIPT = '\uf12c';
  char FA_SUBWAY = '\uf239';
  char FA_SUITCASE = '\uf0f2';
  char FA_SUN_O = '\uf185';
  char FA_SUPERSCRIPT = '\uf12b';
  char FA_SUPPORT = '\uf1cd';
  char FA_TABLE = '\uf0ce';
  char FA_TABLET = '\uf10a';
  char FA_TACHOMETER = '\uf0e4';
  char FA_TAG = '\uf02b';
  char FA_TAGS = '\uf02c';
  char FA_TASKS = '\uf0ae';
  char FA_TAXI = '\uf1ba';
  char FA_TELEVISION = '\uf26c';
  char FA_TENCENT_WEIBO = '\uf1d5';
  char FA_TERMINAL = '\uf120';
  char FA_TEXT_HEIGHT = '\uf034';
  char FA_TEXT_WIDTH = '\uf035';
  char FA_TH = '\uf00a';
  char FA_TH_LARGE = '\uf009';
  char FA_TH_LIST = '\uf00b';
  char FA_THUMB_TACK = '\uf08d';
  char FA_THUMBS_DOWN = '\uf165';
  char FA_THUMBS_O_DOWN = '\uf088';
  char FA_THUMBS_O_UP = '\uf087';
  char FA_THUMBS_UP = '\uf164';
  char FA_TICKET = '\uf145';
  char FA_TIMES = '\uf00d';
  char FA_TIMES_CIRCLE = '\uf057';
  char FA_TIMES_CIRCLE_O = '\uf05c';
  char FA_TINT = '\uf043';
  char FA_TOGGLE_DOWN = '\uf150';
  char FA_TOGGLE_LEFT = '\uf191';
  char FA_TOGGLE_OFF = '\uf204';
  char FA_TOGGLE_ON = '\uf205';
  char FA_TOGGLE_RIGHT = '\uf152';
  char FA_TOGGLE_UP = '\uf151';
  char FA_TRADEMARK = '\uf25c';
  char FA_TRAIN = '\uf238';
  char FA_TRANSGENDER = '\uf224';
  char FA_TRANSGENDER_ALT = '\uf225';
  char FA_TRASH = '\uf1f8';
  char FA_TRASH_O = '\uf014';
  char FA_TREE = '\uf1bb';
  char FA_TRELLO = '\uf181';
  char FA_TRIPADVISOR = '\uf262';
  char FA_TROPHY = '\uf091';
  char FA_TRUCK = '\uf0d1';
  char FA_TRY = '\uf195';
  char FA_TTY = '\uf1e4';
  char FA_TUMBLR = '\uf173';
  char FA_TUMBLR_SQUARE = '\uf174';
  char FA_TURKISH_LIRA = '\uf195';
  char FA_TV = '\uf26c';
  char FA_TWITCH = '\uf1e8';
  char FA_TWITTER = '\uf099';
  char FA_TWITTER_SQUARE = '\uf081';
  char FA_UMBRELLA = '\uf0e9';
  char FA_UNDERLINE = '\uf0cd';
  char FA_UNDO = '\uf0e2';
  char FA_UNIVERSITY = '\uf19c';
  char FA_UNLINK = '\uf127';
  char FA_UNLOCK = '\uf09c';
  char FA_UNLOCK_ALT = '\uf13e';
  char FA_UNSORTED = '\uf0dc';
  char FA_UPLOAD = '\uf093';
  char FA_USD = '\uf155';
  char FA_USER = '\uf007';
  char FA_USER_MD = '\uf0f0';
  char FA_USER_PLUS = '\uf234';
  char FA_USER_SECRET = '\uf21b';
  char FA_USER_TIMES = '\uf235';
  char FA_USERS = '\uf0c0';
  char FA_VENUS = '\uf221';
  char FA_VENUS_DOUBLE = '\uf226';
  char FA_VENUS_MARS = '\uf228';
  char FA_VIACOIN = '\uf237';
  char FA_VIDEO_CAMERA = '\uf03d';
  char FA_VIMEO = '\uf27d';
  char FA_VIMEO_SQUARE = '\uf194';
  char FA_VINE = '\uf1ca';
  char FA_VK = '\uf189';
  char FA_VOLUME_DOWN = '\uf027';
  char FA_VOLUME_OFF = '\uf026';
  char FA_VOLUME_UP = '\uf028';
  char FA_WARNING = '\uf071';
  char FA_WECHAT = '\uf1d7';
  char FA_WEIBO = '\uf18a';
  char FA_WEIXIN = '\uf1d7';
  char FA_WHATSAPP = '\uf232';
  char FA_WHEELCHAIR = '\uf193';
  char FA_WIFI = '\uf1eb';
  char FA_WIKIPEDIA_W = '\uf266';
  char FA_WINDOWS = '\uf17a';
  char FA_WON = '\uf159';
  char FA_WORDPRESS = '\uf19a';
  char FA_WRENCH = '\uf0ad';
  char FA_XING = '\uf168';
  char FA_XING_SQUARE = '\uf169';
  char FA_Y_COMBINATOR = '\uf23b';
  char FA_Y_COMBINATOR_SQUARE = '\uf1d4';
  char FA_YAHOO = '\uf19e';
  char FA_YC = '\uf23b';
  char FA_YC_SQUARE = '\uf1d4';
  char FA_YELP = '\uf1e9';
  char FA_YEN = '\uf157';
  char FA_YOUTUBE = '\uf167';
  char FA_YOUTUBE_PLAY = '\uf16a';
  char FA_YOUTUBE_SQUARE = '\uf166';
}
